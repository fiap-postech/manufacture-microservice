package br.com.fiap.tech.challenge.manufacture.launcher.rest;

import br.com.fiap.tech.challenge.manufacture.launcher.config.ManufactureTestConfiguration;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

import static br.com.fiap.tech.challenge.manufacture.launcher.containers.LocalStackContainers.localStackContainer;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.PurchaseDTOFixture.waitingMakePurchaseDTOModel;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.PurchaseResponseFixture.waitingMakePurchaseResponseModel;
import static br.com.fiap.tech.challenge.manufacture.launcher.util.PurchaseUtil.getPurchaseByUuid;
import static br.com.fiap.tech.challenge.manufacture.launcher.util.PurchaseUtil.sendMessage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.given;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = ManufactureTestConfiguration.class
)
@ActiveProfiles({ "test" })
@DirtiesContext(classMode = AFTER_CLASS)
@Testcontainers
class CreatePurchaseIT {

    private static final Logger LOGGER = getLogger(QueryPurchaseByUuidIT.class);

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private Environment env;

    @Autowired
    private SqsTemplate sqsTemplate;

    @BeforeAll
    static void setup(){
        LOCAL_STACK_CONTAINER.followOutput(new Slf4jLogConsumer(LOGGER));
    }

    @Test
    void testCreatePurchase() {
        var purchaseDTO = create(waitingMakePurchaseDTOModel());
        var purchaseResponse = create(waitingMakePurchaseResponseModel());

        sendMessage(sqsTemplate, env, purchaseDTO);

        given()
                .await()
                .pollInterval(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(20))
                .ignoreExceptions()
                .untilAsserted(() -> {
                    var response = getPurchaseByUuid(purchaseDTO.getId());
                    assertThat(response)
                            .isNotNull()
                            .usingRecursiveComparison()
                            .isEqualTo(purchaseResponse);
                });
    }
}