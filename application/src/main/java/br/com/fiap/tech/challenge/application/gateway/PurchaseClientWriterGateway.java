package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseClientWriterGateway {

    Optional<Purchase> update(UUID uuid, PurchaseStatus status);
}