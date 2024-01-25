package br.com.fiap.tech.challenge.adapter.gateway.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.waitingMakePurchaseModel;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseWriterGatewayTest {

    @Mock
    private PurchaseWriterRepository repository;

    private PurchaseWriterGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = PurchaseGatewayFactory.purchaseWriterGateway(repository);
    }

    @Test
    void shouldSavePurchase() {
        var purchase = create(waitingMakePurchaseModel());

        when(repository.save(any(PurchaseDTO.class)))
                .thenAnswer(i -> Arrays.stream(i.getArguments()).findFirst().orElseThrow());

        var response = gateway.save(purchase);

        assertThat(response)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(purchase);

        verify(repository).save(any(PurchaseDTO.class));
    }
}