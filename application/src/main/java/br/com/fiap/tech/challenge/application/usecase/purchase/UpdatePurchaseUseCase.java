package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

import java.util.UUID;

public interface UpdatePurchaseUseCase {

    Purchase update(UUID uuid, PurchaseStatus status);
}
