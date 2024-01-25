package br.com.fiap.tech.challenge.manufacture.launcher.expectations;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Model;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.JsonBody;

import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.manufacture.launcher.util.JsonUtil.asJsonString;
import static org.mockserver.model.HttpRequest.request;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdatePurchaseExpectations {

    public static <O> HttpRequest updatePurchaseSuccessExpectation(MockServerClient client, String id, PurchaseStatus purchaseStatus, Model<O> output) {
        var request = request()
                .withPath(String.format("/manufacture/%s/%s", id, purchaseStatus))
                .withMethod("PUT");

        var response = HttpResponse.response()
                .withStatusCode(200)
                .withBody(new JsonBody(asJsonString(create(output))));

        client.when(request).respond(response);

        return request;
    }
}