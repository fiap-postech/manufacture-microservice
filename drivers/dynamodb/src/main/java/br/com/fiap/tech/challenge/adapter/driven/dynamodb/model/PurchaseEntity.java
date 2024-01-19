package br.com.fiap.tech.challenge.adapter.driven.dynamodb.model;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;

import java.time.LocalDate;
import java.util.List;

@DynamoDbBean
public class PurchaseEntity {

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

    @DynamoDbSecondaryPartitionKey(indexNames = "purchase-status-date-index")
    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    @DynamoDbSecondarySortKey(indexNames = { "purchase-status-date-index" })
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

    public static final class Builder {
        private String id;
        private PurchaseStatus status;
        private LocalDate date;
        private String code;
        private CustomerEntity customer;
        private List<PurchaseItemEntity> items;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withStatus(PurchaseStatus status) {
            this.status = status;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withCustomer(CustomerEntity customer) {
            this.customer = customer;
            return this;
        }

        public Builder withItems(List<PurchaseItemEntity> items) {
            this.items = items;
            return this;
        }

        public PurchaseEntity build() {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setId(id);
            purchaseEntity.setStatus(status);
            purchaseEntity.setDate(date);
            purchaseEntity.setCode(code);
            purchaseEntity.setCustomer(customer);
            purchaseEntity.setItems(items);
            return purchaseEntity;
        }
    }
}