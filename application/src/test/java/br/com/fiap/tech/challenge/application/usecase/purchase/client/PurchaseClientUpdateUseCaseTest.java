package br.com.fiap.tech.challenge.application.usecase.purchase.client;

import br.com.fiap.tech.challenge.application.fixture.Fixture;
import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.PurchaseUseCaseFactory;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.makingPurchaseModel;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PurchaseClientUpdateUseCaseTest {

    @Mock
    private PurchaseClientWriterGateway purchaseClientWriterGateway;

    private PurchaseClientUpdateUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = PurchaseUseCaseFactory.purchaseClientUpdateUseCase(purchaseClientWriterGateway);
    }

    @Test
    void shouldUpdatePurchase() {
        var purchase = Fixture.create(makingPurchaseModel());

        doNothing().when(purchaseClientWriterGateway).update(purchase.uuid(), PurchaseStatus.MAKING);

        useCase.update(purchase.uuid(), PurchaseStatus.MAKING);

        verify(purchaseClientWriterGateway).update(purchase.uuid(), PurchaseStatus.MAKING);
    }
}