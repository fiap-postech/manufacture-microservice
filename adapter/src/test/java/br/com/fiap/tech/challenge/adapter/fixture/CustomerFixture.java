package br.com.fiap.tech.challenge.adapter.fixture;

import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerFixture {

    public static Model<Customer> customerModel() {
        return Instancio.of(Customer.class)
                .set(field(Customer::uuid), UUID.fromString("9c818571-926a-41a7-97fc-c322d282a395"))
                .set(field(Customer::name), "Jose da Silva")
                .toModel();
    }
}