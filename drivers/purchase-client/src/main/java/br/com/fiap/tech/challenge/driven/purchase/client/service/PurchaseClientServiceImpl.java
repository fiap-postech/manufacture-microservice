package br.com.fiap.tech.challenge.driven.purchase.client.service;

import br.com.fiap.tech.challenge.adapter.repository.PurchaseClientWriterRepository;
import br.com.fiap.tech.challenge.driven.purchase.client.PurchaseClient;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.enterprise.error.ApplicationError;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseClientServiceImpl implements PurchaseClientWriterRepository {

    private final PurchaseClient purchaseClient;

    @Override
    public void update(String id, PurchaseStatus status) {
        var response = purchaseClient.updateStatus(id, status);

        if (response.getStatusCode().is2xxSuccessful()) {
            throw new ApplicationException(ApplicationError.PURCHASE_CLIENT_UPDATE_ERROR);
        }
    }
}