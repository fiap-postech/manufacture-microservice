package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class FindPurchaseByStatusUseCaseImpl implements FindPurchaseByStatusUseCase {

    private final PurchaseReaderGateway gateway;

    @Override
    public List<Purchase> get(PurchaseStatus status) {
        return gateway.readByStatus(status);
    }
}