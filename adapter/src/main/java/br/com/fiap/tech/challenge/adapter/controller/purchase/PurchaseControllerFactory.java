package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
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

    public static FindPurchaseByStatusController findPurchaseByStatusController(FindPurchaseByStatusUseCase useCase, PurchasePresenter presenter) {
        return new FindPurchaseByStatusControllerImpl(useCase, presenter);
    }

    public static UpdatePurchaseController updatePurchaseController(UpdatePurchaseUseCase useCase, PurchasePresenter presenter) {
        return new UpdatePurchaseControllerImpl(useCase, presenter);
    }
}