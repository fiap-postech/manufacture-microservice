package br.com.fiap.tech.challenge.application.fixture;

import br.com.fiap.tech.challenge.application.dto.CreatePurchaseCustomerDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatePurchaseCustomerDTOFixture {

    public static Model<CreatePurchaseCustomerDTO> createPurchaseCustomerDTOModel() {
        return Instancio.of(CreatePurchaseCustomerDTO.class)
                .set(field(CreatePurchaseCustomerDTO::getId), "9c818571-926a-41a7-97fc-c322d282a395")
                .set(field(CreatePurchaseCustomerDTO::getName), "Jose da Silva")
                .toModel();
    }
}