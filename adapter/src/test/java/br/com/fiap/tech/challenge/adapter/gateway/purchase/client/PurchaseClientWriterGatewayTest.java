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

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.makingPurchaseModel;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

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
        var purchase = create(makingPurchaseModel());

        doNothing().when(repository).update(any(String.class), any(PurchaseStatus.class));

        gateway.update(purchase.uuid(), PurchaseStatus.MAKING);

        verify(repository).update(any(String.class), any(PurchaseStatus.class));
    }
}