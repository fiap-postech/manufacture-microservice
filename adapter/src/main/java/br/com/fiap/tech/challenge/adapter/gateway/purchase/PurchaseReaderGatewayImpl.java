package br.com.fiap.tech.challenge.adapter.gateway.purchase;

import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
class PurchaseReaderGatewayImpl implements PurchaseReaderGateway {

    private final PurchaseReaderRepository repository;

    @Override
    public Purchase readById(UUID id) {
        return PurchaseMapper.INSTANCE.toDomain(repository.readById(id.toString()));
    }

    @Override
    public List<Purchase> readByStatus(PurchaseStatus status) {
        return repository.readByStatus(status).stream().map(PurchaseMapper.INSTANCE::toDomain).toList();
    }
}