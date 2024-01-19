package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

public interface CreatePurchaseUseCase {

    Purchase create(CreatePurchaseDTO dto);
}