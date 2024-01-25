package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.error.ApplicationError;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
class FindPurchaseByUUIDUseCaseImpl implements FindPurchaseByUUIDUseCase {

    private final PurchaseReaderGateway gateway;

    @Override
    public Purchase get(UUID uuid) {
        var purchase = gateway.readById(uuid);
        if (isNull(purchase)) {
            throw new ApplicationException(ApplicationError.PURCHASE_NOT_FOUND_BY_UUID, uuid);
        }
        return purchase;
    }
}