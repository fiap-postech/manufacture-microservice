package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.ProductDTOFixture.productDTOModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemDTOFixture {

    public static Model<PurchaseItemDTO> purchaseItemModel() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .set(field(PurchaseItemDTO::getProduct), create(productDTOModel()))
                .toModel();
    }
}