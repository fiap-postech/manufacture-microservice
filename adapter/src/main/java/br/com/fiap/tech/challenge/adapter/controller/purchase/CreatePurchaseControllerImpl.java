package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreatePurchaseControllerImpl implements CreatePurchaseController {

    private final CreatePurchaseUseCase createPurchaseUseCase;
    private final PurchasePresenter purchasePresenter;

    @Override
    public PurchaseDTO create(CreatePurchaseDTO createPurchaseDTO) {
        return purchasePresenter.present(createPurchaseUseCase.create(createPurchaseDTO));
    }
}