package br.com.fiap.tech.challenge.adapter.gateway.purchase.client;

import br.com.fiap.tech.challenge.adapter.repository.PurchaseClientWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PurchaseClientWriterGatewayImpl implements PurchaseClientWriterGateway {

    private final PurchaseClientWriterRepository purchaseClientWriterRepository;

    @Override
    public void update(UUID uuid, PurchaseStatus status) {
        purchaseClientWriterRepository.update(uuid.toString(), status);
    }
}