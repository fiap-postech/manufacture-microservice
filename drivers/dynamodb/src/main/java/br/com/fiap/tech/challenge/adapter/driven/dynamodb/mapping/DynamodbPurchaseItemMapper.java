package br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.ProductEntity;
import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseItemEntity;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Objects.isNull;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class DynamodbPurchaseItemMapper {

    @Autowired
    private DynamodbProductMapper dynamodbProductMapper;

    @Mapping(target = "product", source = "source", qualifiedByName = "getProductEntity")
    abstract PurchaseItemEntity toEntity(PurchaseItemDTO source);


    @Mapping(target = "product", source = "source", qualifiedByName = "getProductDTO")
    abstract PurchaseItemDTO toDTO(PurchaseItemEntity source);


    @Named("getProductEntity")
    ProductEntity getProductEntity(PurchaseItemDTO item) {
        var product = item.getProduct();

        if (isNull(product)) return null;

        return dynamodbProductMapper.toEntity(product);
    }

    @Named("getProductDTO")
    ProductDTO getProductDTO(PurchaseItemEntity entity) {
        var product = entity.getProduct();

        if (isNull(product)) return null;

        return dynamodbProductMapper.toDTO(product);
    }

}
