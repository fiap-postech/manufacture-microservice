package br.com.fiap.tech.challenge.adapter.driven.dynamodb.service;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping.DynamodbPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseWriterRepository;
import io.awspring.cloud.dynamodb.DynamoDbOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamodbPurchaseEntityWriterRepositoryImpl implements PurchaseWriterRepository {

    private final DynamoDbOperations dynamoDbOperations;
    private final DynamodbPurchaseMapper dynamodbPurchaseMapper;

    @Override
    public PurchaseDTO write(PurchaseDTO purchaseDTO) {
        return dynamodbPurchaseMapper.toDTO(dynamoDbOperations.save(dynamodbPurchaseMapper.toEntity(purchaseDTO)));
    }
}