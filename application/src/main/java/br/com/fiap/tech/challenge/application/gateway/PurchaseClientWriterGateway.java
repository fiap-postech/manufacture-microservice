package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.UUID;

public interface PurchaseClientWriterGateway {

    void update(UUID uuid, PurchaseStatus status);
}