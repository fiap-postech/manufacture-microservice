package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.application.dto.CreatePurchaseProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePurchaseProductDTOFixture {

    public static Model<CreatePurchaseProductDTO> createPurchaseProductDTOModel() {
        return Instancio.of(CreatePurchaseProductDTO.class)
                .set(field(CreatePurchaseProductDTO::getId), "0fbeafd9-da38-41c1-b984-418f58d86b2f")
                .set(field(CreatePurchaseProductDTO::getName), "X-Tudo")
                .set(field(CreatePurchaseProductDTO::getDescription), "O mais delicioso X-Tudo")
                .toModel();
    }
}