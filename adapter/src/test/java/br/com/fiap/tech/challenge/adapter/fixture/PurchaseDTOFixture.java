package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.util.List;

import static br.com.fiap.tech.challenge.adapter.fixture.CustomerDTOFixture.customerDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseItemDTOFixture.purchaseItemModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseDTOFixture {

    public static Model<PurchaseDTO> waitingMakingPurchaseDTOModel() {
        return Instancio.of(PurchaseDTO.class)
                .set(field(PurchaseDTO::getId), "bdd276d4-177f-4dfd-a8f6-36f59d1d2747")
                .set(field(PurchaseDTO::getStatus), PurchaseStatus.WAITING_MAKING)
                .set(field(PurchaseDTO::getDate), LocalDate.parse("2024-01-20"))
                .set(field(PurchaseDTO::getCode), "A123")
                .set(field(PurchaseDTO::getCustomer), create(customerDTOModel()))
                .set(field(PurchaseDTO::getItems), List.of(create(purchaseItemModel())))
                .toModel();
    }

    public static Model<PurchaseDTO> makingPurchaseDTOModel() {
        return Instancio.of(waitingMakingPurchaseDTOModel())
                .set(field(PurchaseDTO::getStatus), PurchaseStatus.MAKING)
                .toModel();
    }
}