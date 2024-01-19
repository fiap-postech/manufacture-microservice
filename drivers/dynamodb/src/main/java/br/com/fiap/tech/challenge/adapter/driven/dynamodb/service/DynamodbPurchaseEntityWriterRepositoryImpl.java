package br.com.fiap.tech.challenge.adapter.driven.dynamodb.service;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping.DynamodbPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseEntity;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseWriterRepository;
import io.awspring.cloud.dynamodb.DynamoDbOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class DynamodbPurchaseEntityWriterRepositoryImpl implements PurchaseWriterRepository {

    private final DynamoDbOperations dynamoDbOperations;
    private final DynamodbPurchaseMapper dynamodbPurchaseMapper;

    @Override
    public PurchaseDTO save(PurchaseDTO purchaseDTO) {
        var purchaseEntity = dynamoDbOperations.load(
                Key.builder()
                        .partitionValue(AttributeValue.builder().s(purchaseDTO.getId()).build())
                        .build(),
                PurchaseEntity.class
        );

        if (nonNull(purchaseEntity)) {
            return this.update(purchaseDTO, purchaseEntity);
        }

        return dynamodbPurchaseMapper.toDTO(dynamoDbOperations.save(dynamodbPurchaseMapper.toEntity(purchaseDTO)));
    }

    private PurchaseDTO update(PurchaseDTO purchaseDTO, PurchaseEntity purchaseEntity) {
        purchaseEntity.setStatus(purchaseDTO.getStatus());
        return dynamodbPurchaseMapper.toDTO(dynamoDbOperations.update(purchaseEntity));
    }
}