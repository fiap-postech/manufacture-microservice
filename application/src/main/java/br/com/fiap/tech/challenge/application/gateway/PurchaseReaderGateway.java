package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

import java.util.UUID;

public interface PurchaseReaderGateway {
    Purchase readById(UUID id);
}
