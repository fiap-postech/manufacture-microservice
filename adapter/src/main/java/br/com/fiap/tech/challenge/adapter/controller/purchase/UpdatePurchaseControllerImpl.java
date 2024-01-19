package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdatePurchaseControllerImpl implements UpdatePurchaseController {

    private final UpdatePurchaseUseCase useCase;
    private final PurchasePresenter presenter;

    @Override
    public PurchaseDTO update(String id, PurchaseStatus status) {
        return presenter.present(useCase.update(UUID.fromString(id), status));
    }
}