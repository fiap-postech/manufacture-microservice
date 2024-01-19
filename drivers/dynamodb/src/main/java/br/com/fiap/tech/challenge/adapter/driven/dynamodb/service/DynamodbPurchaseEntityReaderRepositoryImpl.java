package br.com.fiap.tech.challenge.adapter.driven.dynamodb.service;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import io.awspring.cloud.dynamodb.DynamoDbOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamodbPurchaseEntityReaderRepositoryImpl implements PurchaseReaderRepository {

    private final DynamoDbOperations dynamoDbOperations;

    @Override
    public PurchaseDTO readById(String id) {
//        dynamoDbOperations
//                .load(Key.builder().partitionValue(AttributeValue.builder().s(departmentId.toString()).build())
//                        .sortValue(userId.toString()).build(), Department.class);
        return new PurchaseDTO();
    }
}