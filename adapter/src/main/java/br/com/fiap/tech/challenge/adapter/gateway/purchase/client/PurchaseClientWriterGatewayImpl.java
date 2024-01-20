package br.com.fiap.tech.challenge.adapter.gateway.purchase.client;

import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseClientWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PurchaseClientWriterGatewayImpl implements PurchaseClientWriterGateway {

    private final PurchaseClientWriterRepository purchaseClientWriterRepository;

    @Override
    public Optional<Purchase> update(UUID uuid, PurchaseStatus status) {
        var mapper = PurchaseMapper.INSTANCE;

        return purchaseClientWriterRepository.update(uuid.toString(), status).map(mapper::toDomain);
    }
}