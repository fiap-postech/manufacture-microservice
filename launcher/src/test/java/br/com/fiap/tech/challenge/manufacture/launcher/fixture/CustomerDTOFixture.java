package br.com.fiap.tech.challenge.manufacture.launcher.fixture;

import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerDTOFixture {

    public static Model<CustomerDTO> customerDTOModel() {
        return Instancio.of(CustomerDTO.class)
                .set(field(CustomerDTO::getId), "9c818571-926a-41a7-97fc-c322d282a395")
                .set(field(CustomerDTO::getName), "Jose da Silva")
                .toModel();
    }
}