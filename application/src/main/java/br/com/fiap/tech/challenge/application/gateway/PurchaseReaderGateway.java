package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.List;
import java.util.UUID;

public interface PurchaseReaderGateway {
    Purchase readById(UUID id);

    List<Purchase> readByStatus(PurchaseStatus status);
}
