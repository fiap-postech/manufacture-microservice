package br.com.fiap.tech.challenge.manufacture.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.response.ProductResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponseFixture {

    public static Model<ProductResponse> productResponseModel() {
        return Instancio.of(ProductResponse.class)
                .set(field(ProductResponse::getId), "0fbeafd9-da38-41c1-b984-418f58d86b2f")
                .set(field(ProductResponse::getName), "X-Tudo")
                .set(field(ProductResponse::getDescription), "O mais delicioso X-Tudo")
                .toModel();
    }
}