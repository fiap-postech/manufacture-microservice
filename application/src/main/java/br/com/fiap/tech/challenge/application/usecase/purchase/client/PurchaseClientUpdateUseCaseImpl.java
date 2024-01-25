package br.com.fiap.tech.challenge.application.usecase.purchase.client;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PurchaseClientUpdateUseCaseImpl implements PurchaseClientUpdateUseCase {

    private final PurchaseClientWriterGateway purchaseClientWriterGateway;

    @Override
    public void update(UUID uuid, PurchaseStatus status) {
        purchaseClientWriterGateway.update(uuid, status);
    }
}