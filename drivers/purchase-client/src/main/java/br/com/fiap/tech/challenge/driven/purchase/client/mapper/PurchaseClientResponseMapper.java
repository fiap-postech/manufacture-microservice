package br.com.fiap.tech.challenge.driven.purchase.client.mapper;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.driven.purchase.client.response.PurchaseResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PurchaseClientResponseMapper {

    PurchaseDTO toDTO(PurchaseResponse response);
}
