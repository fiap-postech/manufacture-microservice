package br.com.fiap.tech.challenge.adapter.mapping;

import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import static br.com.fiap.tech.challenge.util.Mappings.quantityToIntegerConverter;

@Mapper(uses = { CommonMapper.class })
public interface PurchaseItemMapper {

    PurchaseItemMapper INSTANCE = Mappers.getMapper(PurchaseItemMapper.class);

    @Mapping(target = "product", source = "item", qualifiedByName = "mapToProductDTO")
    @Mapping(target = "quantity", source = "item", qualifiedByName = "mapQuantity")
    PurchaseItemDTO toDTO(PurchaseItem item);

    @Mapping(target = "product", source = "product", qualifiedByName = "mapToProductDomain")
    @Mapping(target = "quantity", source = "quantity", qualifiedByName = "getQuantityVO")
    PurchaseItem toDomain(PurchaseItemDTO dto);

    @Named("mapToProductDTO")
    static ProductDTO mapToProductDTO(PurchaseItem item){
        return ProductMapper.INSTANCE.toDTO(item.product());
    }

    @Named("mapQuantity")
    static Integer mapQuantity(PurchaseItem item) {
        return quantityToIntegerConverter(item.quantity());
    }

    @Named("mapToProductDomain")
    static Product mapToProductDomain(ProductDTO dto) {
        return ProductMapper.INSTANCE.toDomain(dto);
    }
}