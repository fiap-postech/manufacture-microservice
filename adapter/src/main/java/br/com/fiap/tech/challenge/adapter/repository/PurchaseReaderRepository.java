package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.List;

public interface PurchaseReaderRepository {

    PurchaseDTO readById(String id);

    List<PurchaseDTO> readByStatus(PurchaseStatus status);
}