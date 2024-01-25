package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.waitingMakePurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.waitingMakePurchaseModel;
import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_NOT_FOUND_BY_UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPurchaseByUUIDControllerTest {

    @Mock
    private FindPurchaseByUUIDUseCase useCase;

    @Mock
    private PurchasePresenter presenter;

    private FindPurchaseByUUIDController controller;

    @BeforeEach
    void setUp(){
        controller = PurchaseControllerFactory.findPurchaseByUUIDController(useCase, presenter);
    }

    @Test
    void shouldReturnPurchaseWhenExists() {
        var purchase = create(waitingMakePurchaseModel());
        var purchaseDTO = create(waitingMakePurchaseDTOModel());

        when(useCase.get(any(UUID.class))).thenReturn(purchase);
        when(presenter.present(purchase)).thenReturn(purchaseDTO);

        var response = controller.get("bdd276d4-177f-4dfd-a8f6-36f59d1d2747");

        assertThat(response)
                .isNotNull()
                .isEqualTo(purchaseDTO);

        verify(useCase).get(any(UUID.class));
        verify(presenter).present(purchase);
    }

    @Test
    void shouldThrowsExceptionWhenNotExists() {
        var exception = new ApplicationException(PURCHASE_NOT_FOUND_BY_UUID);

        when(useCase.get(any(UUID.class))).thenThrow(exception);

        assertThatThrownBy(() -> controller.get("6a568870-3784-4b7c-a55c-bd005873046a"))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(exception.getMessage());

        verify(useCase).get(any(UUID.class));
    }
}