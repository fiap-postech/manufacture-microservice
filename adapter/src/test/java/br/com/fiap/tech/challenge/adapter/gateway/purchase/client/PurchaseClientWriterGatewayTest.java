package br.com.fiap.tech.challenge.adapter.gateway.purchase.client;

import br.com.fiap.tech.challenge.adapter.gateway.purchase.PurchaseGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseClientWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.makingPurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.makingPurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseClientWriterGatewayTest {

    @Mock
    private PurchaseClientWriterRepository repository;

    private PurchaseClientWriterGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = PurchaseGatewayFactory.purchaseClientWriterGateway(repository);
    }

    @Test
    void shouldUpdatePurchase() {
        var purchaseDTO = create(makingPurchaseDTOModel());
        var purchase = create(makingPurchaseModel());

        when(repository.update(any(String.class), any(PurchaseStatus.class)))
                .thenReturn(Optional.of(purchaseDTO));

        var response = gateway.update(purchase.uuid(), PurchaseStatus.MAKING);

        assertThat(response)
                .isPresent()
                .get()
                .usingRecursiveComparison()
                .isEqualTo(purchase);

        verify(repository).update(any(String.class), any(PurchaseStatus.class));
    }
}