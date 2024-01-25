package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUseCase;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.UUID;

import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.makingPurchaseModel;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.waitingMakePurchaseModel;
import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_NOT_FOUND_BY_UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdatePurchaseUseCaseTest {

    @Mock
    private FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase;

    @Mock
    private PurchaseClientUpdateUseCase purchaseClientUpdateUseCase;

    @Mock
    private PurchaseWriterGateway purchaseWriterGateway;

    private UpdatePurchaseUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = PurchaseUseCaseFactory.updatePurchaseUseCase(findPurchaseByUUIDUseCase, purchaseClientUpdateUseCase, purchaseWriterGateway);
    }

    @Test
    void shouldChangePurchaseStatus() {
        var waitingMakePurchase = create(waitingMakePurchaseModel());
        var makingPurchase = create(makingPurchaseModel());

        when(findPurchaseByUUIDUseCase.get(any(UUID.class))).thenReturn(waitingMakePurchase);
        doNothing().when(purchaseClientUpdateUseCase).update(any(UUID.class), any(PurchaseStatus.class));
        when(purchaseWriterGateway.save(any(Purchase.class)))
                .thenAnswer(i -> Arrays.stream(i.getArguments()).findFirst().orElseThrow());

        var response = useCase.update(waitingMakePurchase.uuid(), PurchaseStatus.MAKING);

        assertThat(response)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(makingPurchase);

        verify(findPurchaseByUUIDUseCase).get(any(UUID.class));
        verify(purchaseClientUpdateUseCase).update(any(UUID.class), any(PurchaseStatus.class));
        verify(purchaseWriterGateway).save(any(Purchase.class));
    }

    @Test
    void shouldThrowsWhenNotExists() {
        var uuid = UUID.fromString("6a568870-3784-4b7c-a55c-bd005873046a");
        var exception = new ApplicationException(PURCHASE_NOT_FOUND_BY_UUID);

        when(findPurchaseByUUIDUseCase.get(any(UUID.class))).thenThrow(exception);

        assertThatThrownBy(() -> useCase.update(uuid, PurchaseStatus.MAKING))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(exception.getMessage());

        verify(findPurchaseByUUIDUseCase).get(any(UUID.class));
    }

    @Test
    void shouldThrowsWhenIsInvalidStatus() {
        var makingPurchase = create(makingPurchaseModel());
        var uuid = makingPurchase.uuid();
        var status = PurchaseStatus.MAKING;

        when(findPurchaseByUUIDUseCase.get(any(UUID.class))).thenReturn(makingPurchase);

        assertThatThrownBy(() -> useCase.update(uuid, status))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(String.format("Invalid purchase status [status=%s]", status));

        verify(findPurchaseByUUIDUseCase).get(any(UUID.class));
    }
}