package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseControllerFactory {

    public static CreatePurchaseController createPurchaseController(CreatePurchaseUseCase useCase, PurchasePresenter presenter) {
        return new CreatePurchaseControllerImpl(useCase, presenter);
    }

    public static FindPurchaseByUUIDController findPurchaseByUUIDController(FindPurchaseByUUIDUseCase useCase, PurchasePresenter presenter) {
        return new FindPurchaseByUUIDControllerImpl(useCase, presenter);
    }
}
