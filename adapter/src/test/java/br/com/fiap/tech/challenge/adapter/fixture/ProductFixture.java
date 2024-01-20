package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.enterprise.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductFixture {

    public static Model<Product> productModel() {
        return Instancio.of(Product.class)
                .set(field(Product::uuid), UUID.fromString("0fbeafd9-da38-41c1-b984-418f58d86b2f"))
                .set(field(Product::name), "X-Tudo")
                .set(field(Product::description), "O mais delicioso X-Tudo")
                .toModel();
    }
}