package br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.ProductEntity;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DynamodbProductMapper {

    ProductEntity toEntity(ProductDTO dto);

    ProductDTO toDTO(ProductEntity entity);

}