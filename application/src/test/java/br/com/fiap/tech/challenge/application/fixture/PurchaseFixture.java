package br.com.fiap.tech.challenge.application.fixture;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static br.com.fiap.tech.challenge.application.fixture.CustomerFixture.customerModel;
import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseItemFixture.purchaseItemModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseFixture {

    public static Model<Purchase> waitingMakingPurchaseModel() {
        return Instancio.of(Purchase.class)
                .set(field(Purchase::uuid), UUID.fromString("bdd276d4-177f-4dfd-a8f6-36f59d1d2747"))
                .set(field(Purchase::status), PurchaseStatus.WAITING_MAKING)
                .set(field(Purchase::date), LocalDate.parse("2024-01-20"))
                .set(field(Purchase::code), "A123")
                .set(field(Purchase::customer), create(customerModel()))
                .set(field(Purchase::items), List.of(create(purchaseItemModel())))
                .toModel();
    }

    public static Model<Purchase> makingPurchaseModel() {
        return Instancio.of(waitingMakingPurchaseModel())
                .set(field(Purchase::status), PurchaseStatus.MAKING)
                .toModel();
    }
}