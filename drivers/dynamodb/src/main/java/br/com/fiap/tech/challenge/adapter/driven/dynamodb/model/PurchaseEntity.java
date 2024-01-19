package br.com.fiap.tech.challenge.adapter.driven.dynamodb.model;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;

import java.time.LocalDate;
import java.util.List;

@Data
@DynamoDbBean
public class PurchaseEntity {

    public static final String PURCHASE_STATUS_DATE_INDEX = "purchase-status-date-index";

    private String id;
    private PurchaseStatus status;
    private LocalDate date;
    private String code;
    private CustomerEntity customer;
    private List<PurchaseItemEntity> items;
    private Long ttl;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = PURCHASE_STATUS_DATE_INDEX)
    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    @DynamoDbSecondarySortKey(indexNames = { PURCHASE_STATUS_DATE_INDEX })
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<PurchaseItemEntity> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItemEntity> items) {
        this.items = items;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }
}