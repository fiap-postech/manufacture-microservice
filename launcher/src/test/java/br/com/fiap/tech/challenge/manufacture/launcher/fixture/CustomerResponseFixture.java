package br.com.fiap.tech.challenge.manufacture.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.response.CustomerResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerResponseFixture {

    public static Model<CustomerResponse> customerResponseModel() {
        return Instancio.of(CustomerResponse.class)
                .set(field(CustomerResponse::getId), "9c818571-926a-41a7-97fc-c322d282a395")
                .set(field(CustomerResponse::getName), "Jose da Silva")
                .toModel();
    }
}
