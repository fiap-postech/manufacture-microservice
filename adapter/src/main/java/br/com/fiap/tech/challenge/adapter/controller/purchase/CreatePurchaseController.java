package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;

public interface CreatePurchaseController {

    PurchaseDTO create(CreatePurchaseDTO createPurchaseDTO);
}