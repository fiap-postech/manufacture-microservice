package br.com.fiap.tech.challenge.manufacture.launcher.util;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.rest.resource.response.PurchaseResponse;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static br.com.fiap.tech.challenge.manufacture.launcher.util.JsonUtil.fromJsonString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseUtil {

    private static final Logger LOGGER = getLogger(PurchaseUtil.class);

    public static void sendMessage(SqsTemplate sqsTemplate, Environment env, PurchaseDTO purchaseDTO) {
        sqsTemplate.send(env.getProperty("aws.sqs.manufacture-purchase-created-queue.name"), purchaseDTO);
    }

    public static PurchaseResponse getPurchaseByUuid(String uuid) {
        try {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format("http://localhost:8693/manufacture/%s", uuid)))
                    .headers("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .GET()
                    .build();

            var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            assertThat(response.statusCode()).isEqualTo(200);

            return fromJsonString(response.body(), PurchaseResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}