package br.com.fiap.tech.challenge.adapter.controller.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.List;

public interface FindPurchaseByStatusController {

    List<PurchaseDTO> get(PurchaseStatus status);
}