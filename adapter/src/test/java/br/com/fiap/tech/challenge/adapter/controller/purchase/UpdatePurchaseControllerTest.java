package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.waitingMakePurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.makingPurchaseModel;
import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_CLIENT_NOT_FOUND_BY_UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdatePurchaseControllerTest {

    @Mock
    private UpdatePurchaseUseCase useCase;

    @Mock
    private PurchasePresenter presenter;

    private UpdatePurchaseController controller;

    @BeforeEach
    void setUp(){
        controller = PurchaseControllerFactory.updatePurchaseController(useCase, presenter);
    }

    @Test
    void shouldChangePurchaseStatus() {
        var purchase = create(makingPurchaseModel());
        var purchaseDTO = create(waitingMakePurchaseDTOModel());

        when(useCase.update(any(UUID.class), any(PurchaseStatus.class))).thenReturn(purchase);
        when(presenter.present(purchase)).thenReturn(purchaseDTO);

        var response = controller.update("bdd276d4-177f-4dfd-a8f6-36f59d1d2747", PurchaseStatus.MAKING);

        assertThat(response)
                .isNotNull()
                .isEqualTo(purchaseDTO);

        verify(useCase).update(any(UUID.class), any(PurchaseStatus.class));
        verify(presenter).present(purchase);
    }

    @Test
    void shouldThrowsWhenNotExists() {
        var exception = new ApplicationException(PURCHASE_CLIENT_NOT_FOUND_BY_UUID);

        when(useCase.update(any(UUID.class), any(PurchaseStatus.class))).thenThrow(exception);

        assertThatThrownBy(() -> controller.update("6a568870-3784-4b7c-a55c-bd005873046a", PurchaseStatus.MAKING))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(exception.getMessage());

        verify(useCase).update(any(UUID.class), any(PurchaseStatus.class));
    }
}