package br.com.fiap.tech.challenge.driven.purchase.client.service;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseClientWriterRepository;
import br.com.fiap.tech.challenge.driven.purchase.client.PurchaseClient;
import br.com.fiap.tech.challenge.driven.purchase.client.mapper.PurchaseClientResponseMapper;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseClientServiceImpl implements PurchaseClientWriterRepository {

    private final PurchaseClient purchaseClient;
    private final PurchaseClientResponseMapper purchaseClientResponseMapper;

    @Override
    public Optional<PurchaseDTO> update(String id, PurchaseStatus status) {
        var response = purchaseClient.updateStatus(id, status);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Optional.of(purchaseClientResponseMapper.toDTO(response.getBody()));
        }

        return Optional.empty();
    }
}