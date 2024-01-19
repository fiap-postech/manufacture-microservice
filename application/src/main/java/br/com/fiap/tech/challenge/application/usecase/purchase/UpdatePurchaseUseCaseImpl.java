package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUserCase;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.INVALID_PURCHASE_STATUS;

@RequiredArgsConstructor
public class UpdatePurchaseUseCaseImpl implements UpdatePurchaseUseCase {

    private final FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase;
    private final PurchaseClientUpdateUserCase purchaseClientUpdateUserCase;
    private final PurchaseWriterGateway purchaseWriterGateway;

    @Override
    public Purchase update(UUID uuid, PurchaseStatus status) {
        var purchase = findPurchaseByUUIDUseCase.get(uuid);

        this.validateStatus(status, purchase);

        purchaseClientUpdateUserCase.update(purchase.uuid(), status);

        return this.update(status, purchase);
    }

    private Purchase update(PurchaseStatus status, Purchase purchase) {
        var updatedPurchase = purchase.updateStatus(status);
        return purchaseWriterGateway.save(updatedPurchase);
    }

    private void validateStatus(PurchaseStatus status, Purchase purchase) {
        if (!purchase.status().isNextStatusValid(status)) {
            throw new ApplicationException(INVALID_PURCHASE_STATUS, status);
        }
    }
}