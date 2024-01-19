package br.com.fiap.tech.challenge.adapter.driven.dynamodb.service;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping.DynamodbPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseEntity;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import io.awspring.cloud.dynamodb.DynamoDbOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@Service
@RequiredArgsConstructor
public class DynamodbPurchaseEntityReaderRepositoryImpl implements PurchaseReaderRepository {

    private final DynamoDbOperations dynamoDbOperations;
    private final DynamodbPurchaseMapper dynamodbPurchaseMapper;

    @Override
    public PurchaseDTO readById(String id) {
        var entity = dynamoDbOperations.load(
                Key.builder()
                        .partitionValue(AttributeValue.builder().s(id).build())
                        .build(),
                PurchaseEntity.class
        );
        return dynamodbPurchaseMapper.toDTO(entity);
    }
}