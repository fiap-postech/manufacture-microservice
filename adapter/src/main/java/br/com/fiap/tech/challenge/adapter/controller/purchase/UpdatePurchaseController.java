package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

public interface UpdatePurchaseController {

    PurchaseDTO update(String id, PurchaseStatus status);
}
