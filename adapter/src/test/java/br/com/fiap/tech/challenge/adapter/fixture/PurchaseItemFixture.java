package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import br.com.fiap.tech.challenge.enterprise.valueobject.Quantity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.ProductFixture.productModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemFixture {

    public static Model<PurchaseItem> purchaseItemModel() {
        return Instancio.of(PurchaseItem.class)
                .set(field(PurchaseItem::quantity), Quantity.of(1))
                .set(field(PurchaseItem::product), create(productModel()))
                .toModel();
    }
}