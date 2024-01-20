package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.fiap.tech.challenge.adapter.fixture.CreatePurchaseDTOFixture.createPurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.waitingMakingPurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.waitingMakingPurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePurchaseControllerTest {

    @Mock
    private CreatePurchaseUseCase useCase;

    @Mock
    private PurchasePresenter presenter;

    private CreatePurchaseController controller;

    @BeforeEach
    void setUp(){
        controller = PurchaseControllerFactory.createPurchaseController(useCase, presenter);
    }

    @Test
    void shouldCreatePurchase() {
        var createPurchaseDTO = create(createPurchaseDTOModel());
        var purchase = create(waitingMakingPurchaseModel());
        var purchaseDTO = create(waitingMakingPurchaseDTOModel());

        when(useCase.create(createPurchaseDTO)).thenReturn(purchase);
        when(presenter.present(purchase)).thenReturn(purchaseDTO);

        var response = controller.create(createPurchaseDTO);

        assertThat(response)
                .isNotNull()
                .isEqualTo(purchaseDTO);

        verify(useCase).create(createPurchaseDTO);
        verify(presenter).present(purchase);
    }
}