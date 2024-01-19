package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PurchaseReaderRepository {

    PurchaseDTO readById(String id);

}