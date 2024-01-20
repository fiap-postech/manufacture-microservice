package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.application.dto.CreatePurchasePurchaseItemDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.adapter.fixture.CreatePurchaseProductDTOFixture.createPurchaseProductDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePurchasePurchaseItemDTOFixture {

    public static Model<CreatePurchasePurchaseItemDTO> createPurchasePurchaseItemDTOModel() {
        return Instancio.of(CreatePurchasePurchaseItemDTO.class)
                .set(field(CreatePurchasePurchaseItemDTO::getQuantity), 1)
                .set(field(CreatePurchasePurchaseItemDTO::getProduct), create(createPurchaseProductDTOModel()))
                .toModel();
    }
}