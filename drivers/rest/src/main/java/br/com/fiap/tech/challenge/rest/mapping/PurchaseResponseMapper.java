package br.com.fiap.tech.challenge.rest.mapping;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.rest.resource.response.PurchaseResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        uses = { PurchaseItemResponseMapper.class, CustomerResponseMapper.class }
)
public interface PurchaseResponseMapper {

    PurchaseResponse toResponse(PurchaseDTO dto);
}
