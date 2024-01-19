package br.com.fiap.tech.challenge.driven.consumer.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CreatePurchaseMapper {

    CreatePurchaseMapper INSTANCE = Mappers.getMapper(CreatePurchaseMapper.class);

    CreatePurchaseDTO toDTO(PurchaseDTO dto);
}