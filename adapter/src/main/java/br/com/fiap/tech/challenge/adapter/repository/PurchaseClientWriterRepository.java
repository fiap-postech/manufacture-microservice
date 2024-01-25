package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

public interface PurchaseClientWriterRepository {

    void update(String id, PurchaseStatus status);
}