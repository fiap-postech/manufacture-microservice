package br.com.fiap.tech.challenge.adapter.driven.dynamodb.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class PurchaseItemEntity {

    private ProductEntity product;
    private Integer quantity;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static final class Builder {
        private ProductEntity product;
        private Integer quantity;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withProcuct(ProductEntity product) {
            this.product = product;
            return this;
        }

        public Builder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public PurchaseItemEntity build() {
            PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();
            purchaseItemEntity.setProduct(product);
            purchaseItemEntity.setQuantity(quantity);
            return purchaseItemEntity;
        }
    }
}