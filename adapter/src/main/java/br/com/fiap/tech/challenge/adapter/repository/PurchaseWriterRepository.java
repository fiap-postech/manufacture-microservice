package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PurchaseWriterRepository {

    PurchaseDTO save(PurchaseDTO purchaseDTO);
}