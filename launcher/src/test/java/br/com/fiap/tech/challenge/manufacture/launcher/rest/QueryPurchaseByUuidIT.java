package br.com.fiap.tech.challenge.manufacture.launcher.rest;

import br.com.fiap.tech.challenge.manufacture.launcher.config.ManufactureTestConfiguration;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.restassured.RestAssured;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

import static br.com.fiap.tech.challenge.manufacture.launcher.containers.LocalStackContainers.localStackContainer;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.PurchaseDTOFixture.waitingMakingPurchaseDTOModel;
import static br.com.fiap.tech.challenge.manufacture.launcher.util.ConfigurationOverrides.overrideConfiguration;
import static br.com.fiap.tech.challenge.manufacture.launcher.util.PurchaseUtil.sendMessage;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = ManufactureTestConfiguration.class
)
@ActiveProfiles({ "test" })
@DirtiesContext(classMode = AFTER_CLASS)
@Testcontainers
class QueryPurchaseByUuidIT {

    private static final Logger LOGGER = getLogger(QueryPurchaseByUuidIT.class);

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private Environment env;

    @Autowired
    private SqsTemplate sqsTemplate;

    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        overrideConfiguration(registry);
    }

    @BeforeAll
    static void setup(){
        LOCAL_STACK_CONTAINER.followOutput(new Slf4jLogConsumer(LOGGER));
    }

    @Test
    void testFindPurchaseByUuid() {
        var purchaseDTO = create(waitingMakingPurchaseDTOModel());

        sendMessage(sqsTemplate, env, purchaseDTO);

        Awaitility.given()
                .await()
                .pollInterval(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(20))
                .ignoreExceptions()
                .untilAsserted(() -> {
                    RestAssured.given()
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .when()
                            .get("/manufacture/{id}", purchaseDTO.getId())
                        .then()
                            .statusCode(HttpStatus.OK.value())
                            .body(matchesJsonSchemaInClasspath("./schemas/PurchaseResponseSchema.json"));
                });
    }
}