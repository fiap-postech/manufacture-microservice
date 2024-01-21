package br.com.fiap.tech.challenge.manufacture.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.response.PurchaseItemResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.ProductResponseFixture.productResponseModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemResponseFixture {

    public static Model<PurchaseItemResponse> purchaseItemResponseModel() {
        return Instancio.of(PurchaseItemResponse.class)
                .set(field(PurchaseItemResponse::getQuantity), 1)
                .set(field(PurchaseItemResponse::getProduct), create(productResponseModel()))
                .toModel();
    }
}