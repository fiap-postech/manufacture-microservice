package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDTOFixture {

    public static Model<ProductDTO> productDTOModel() {
        return Instancio.of(ProductDTO.class)
                .set(field(ProductDTO::getId), "0fbeafd9-da38-41c1-b984-418f58d86b2f")
                .set(field(ProductDTO::getName), "X-Tudo")
                .set(field(ProductDTO::getDescription), "O mais delicioso X-Tudo")
                .toModel();
    }
}