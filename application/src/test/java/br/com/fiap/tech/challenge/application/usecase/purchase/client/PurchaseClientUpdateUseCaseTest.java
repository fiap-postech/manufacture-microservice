package br.com.fiap.tech.challenge.application.usecase.purchase.client;

import br.com.fiap.tech.challenge.application.fixture.Fixture;
import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.PurchaseUseCaseFactory;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.makingPurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        when(purchaseClientWriterGateway.update(purchase.uuid(), PurchaseStatus.MAKING)).thenReturn(Optional.of(purchase));

        var response = useCase.update(purchase.uuid(), PurchaseStatus.MAKING);

        assertThat(response).usingRecursiveComparison().isEqualTo(purchase);

        verify(purchaseClientWriterGateway).update(purchase.uuid(), PurchaseStatus.MAKING);
    }

    @Test
    void shouldThrowsExceptionWhenNotExists() {
        var uuid = UUID.randomUUID();

        when(purchaseClientWriterGateway.update(any(UUID.class), any(PurchaseStatus.class))).thenReturn(Optional.empty());

        assertThatThrownBy(() -> useCase.update(uuid, PurchaseStatus.MAKING))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(String.format("Purchase not found [uuid=%s]", uuid.toString()));

        verify(purchaseClientWriterGateway).update(any(UUID.class), any(PurchaseStatus.class));
    }
}