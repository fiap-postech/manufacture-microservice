package br.com.fiap.tech.challenge.application.usecase.purchase.client;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.UUID;

public interface PurchaseClientUpdateUseCase {

    void update(UUID uuid, PurchaseStatus status);
}
