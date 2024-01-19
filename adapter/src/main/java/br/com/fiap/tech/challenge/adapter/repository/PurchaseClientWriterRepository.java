package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.Optional;

public interface PurchaseClientWriterRepository {

    Optional<PurchaseDTO> update(String id, PurchaseStatus status);
}