package br.com.fiap.tech.challenge.adapter.driven.dynamodb.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class ProductEntity  {

    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class Builder {
        private String id;
        private String name;
        private String description;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductEntity build() {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setId(id);
            productEntity.setName(name);
            productEntity.setDescription(description);
            return productEntity;
        }
    }
}