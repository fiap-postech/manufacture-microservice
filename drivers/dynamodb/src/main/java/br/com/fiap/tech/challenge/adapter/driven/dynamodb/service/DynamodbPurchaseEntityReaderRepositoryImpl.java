package br.com.fiap.tech.challenge.adapter.driven.dynamodb.service;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping.DynamodbPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseEntity;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import io.awspring.cloud.dynamodb.DynamoDbOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;

import static br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseEntity.PURCHASE_STATUS_DATE_INDEX;

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

    @Override
    public List<PurchaseDTO> readByStatus(PurchaseStatus status) {
        return dynamoDbOperations.query(
                QueryEnhancedRequest.builder()
                        .queryConditional(QueryConditional
                                .keyEqualTo(Key.builder().partitionValue(status.name()).build()))
                        .build(),
                PurchaseEntity.class,
                PURCHASE_STATUS_DATE_INDEX)
                .items().stream().map(dynamodbPurchaseMapper::toDTO).toList();
    }
}