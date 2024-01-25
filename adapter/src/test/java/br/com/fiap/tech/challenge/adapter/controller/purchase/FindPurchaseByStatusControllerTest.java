package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.waitingMakePurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.waitingMakePurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPurchaseByStatusControllerTest {

    @Mock
    private FindPurchaseByStatusUseCase useCase;

    @Mock
    private PurchasePresenter presenter;

    private FindPurchaseByStatusController controller;

    @BeforeEach
    void setUp(){
        controller = PurchaseControllerFactory.findPurchaseByStatusController(useCase, presenter);
    }

    @Test
    void shouldReturnPurchasesWhenExists() {
        var purchases = List.of(create(waitingMakePurchaseModel()));
        var purchaseDTO = create(waitingMakePurchaseDTOModel());
        var purchaseDTOs = List.of(purchaseDTO);

        when(useCase.get(any(PurchaseStatus.class))).thenReturn(purchases);
        when(presenter.present(purchases)).thenReturn(purchaseDTOs);

        var response = controller.get(PurchaseStatus.WAITING_MAKE);

        assertThat(response)
                .isNotNull()
                .hasSizeGreaterThan(0)
                .contains(purchaseDTO);

        verify(useCase).get(any(PurchaseStatus.class));
        verify(presenter).present(purchases);
    }

    @Test
    void shouldReturnEmptyWhenNotExists() {
        when(useCase.get(any(PurchaseStatus.class))).thenReturn(List.of());

        var response = controller.get(PurchaseStatus.WAITING_MAKE);

        assertThat(response)
                .isNotNull()
                .isEmpty();

        verify(useCase).get(any(PurchaseStatus.class));
    }
}