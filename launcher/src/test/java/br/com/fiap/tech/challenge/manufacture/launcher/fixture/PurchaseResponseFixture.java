package br.com.fiap.tech.challenge.manufacture.launcher.fixture;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.rest.resource.response.PurchaseResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.util.List;

import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.CustomerResponseFixture.customerResponseModel;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.manufacture.launcher.fixture.PurchaseItemResponseFixture.purchaseItemResponseModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseResponseFixture {

    public static Model<PurchaseResponse> waitingMakingPurchaseResponseModel() {
        return Instancio.of(PurchaseResponse.class)
                .set(field(PurchaseResponse::getId), "bdd276d4-177f-4dfd-a8f6-36f59d1d2747")
                .set(field(PurchaseResponse::getStatus), PurchaseStatus.WAITING_MAKING)
                .set(field(PurchaseResponse::getDate), LocalDate.parse("2024-01-20"))
                .set(field(PurchaseResponse::getCode), "A123")
                .set(field(PurchaseResponse::getCustomer), create(customerResponseModel()))
                .set(field(PurchaseResponse::getItems), List.of(create(purchaseItemResponseModel())))
                .toModel();
    }

    public static Model<PurchaseResponse> makingPurchaseResponseModel() {
        return Instancio.of(waitingMakingPurchaseResponseModel())
                .set(field(PurchaseResponse::getStatus), PurchaseStatus.MAKING)
                .toModel();
    }
}