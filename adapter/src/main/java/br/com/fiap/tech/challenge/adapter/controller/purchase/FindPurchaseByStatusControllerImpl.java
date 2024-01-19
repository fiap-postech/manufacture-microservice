package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindPurchaseByStatusControllerImpl implements FindPurchaseByStatusController {

    private final FindPurchaseByStatusUseCase useCase;
    private final PurchasePresenter presenter;

    @Override
    public List<PurchaseDTO> get(PurchaseStatus status) {
        return presenter.present(useCase.get(status));
    }
}