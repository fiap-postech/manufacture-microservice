package br.com.fiap.tech.challenge.application.usecase.purchase.client;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_CLIENT_NOT_FOUND_BY_UUID;

@RequiredArgsConstructor
public class PurchaseClientUpdateUseCaseImpl implements PurchaseClientUpdateUseCase {

    private final PurchaseClientWriterGateway purchaseClientWriterGateway;

    @Override
    public Purchase update(UUID uuid, PurchaseStatus status) {
        return purchaseClientWriterGateway.update(uuid, status)
                .orElseThrow(() -> new ApplicationException(PURCHASE_CLIENT_NOT_FOUND_BY_UUID, uuid.toString()));
    }
}