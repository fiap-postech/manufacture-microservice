package br.com.fiap.tech.challenge.application.fixture;

import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.util.List;

import static br.com.fiap.tech.challenge.application.fixture.CreatePurchaseCustomerDTOFixture.createPurchaseCustomerDTOModel;
import static br.com.fiap.tech.challenge.application.fixture.CreatePurchasePurchaseItemDTOFixture.createPurchasePurchaseItemDTOModel;
import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePurchaseDTOFixture {

    public static Model<CreatePurchaseDTO> createPurchaseDTOModel() {
        return Instancio.of(CreatePurchaseDTO.class)
                .set(field(CreatePurchaseDTO::getId), "bdd276d4-177f-4dfd-a8f6-36f59d1d2747")
                .set(field(CreatePurchaseDTO::getStatus), PurchaseStatus.WAITING_MAKE)
                .set(field(CreatePurchaseDTO::getDate), LocalDate.parse("2024-01-20"))
                .set(field(CreatePurchaseDTO::getCode), "A123")
                .set(field(CreatePurchaseDTO::getCustomer), create(createPurchaseCustomerDTOModel()))
                .set(field(CreatePurchaseDTO::getItems), List.of(create(createPurchasePurchaseItemDTOModel())))
                .toModel();
    }
}