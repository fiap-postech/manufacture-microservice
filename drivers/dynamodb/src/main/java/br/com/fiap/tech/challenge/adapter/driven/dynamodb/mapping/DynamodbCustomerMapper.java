package br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.CustomerEntity;
import br.com.fiap.tech.challenge.adapter.dto.CustomerDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DynamodbCustomerMapper {

    CustomerEntity toEntity(CustomerDTO dto);

    CustomerDTO toDTO(CustomerEntity entity);
}
