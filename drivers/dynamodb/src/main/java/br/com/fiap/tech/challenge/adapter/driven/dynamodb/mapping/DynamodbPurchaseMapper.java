package br.com.fiap.tech.challenge.adapter.driven.dynamodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.model.PurchaseEntity;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static br.com.fiap.tech.challenge.adapter.driven.dynamodb.utils.TtlUtils.TTL_KEY;
import static br.com.fiap.tech.challenge.adapter.driven.dynamodb.utils.TtlUtils.inSeconds;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = { DynamodbCustomerMapper.class, DynamodbPurchaseItemMapper.class })
public abstract class DynamodbPurchaseMapper {

    @Autowired
    protected Environment env;

    @Mapping(target = "ttl", source = "dto", qualifiedByName = "getTtlFromEnv")
    public abstract PurchaseEntity toEntity(PurchaseDTO dto);

    public abstract PurchaseDTO toDTO(PurchaseEntity entity);

    @Named("getTtlFromEnv")
    Long getTtlFromEnv(PurchaseDTO dto){
        return inSeconds(env.getProperty(TTL_KEY, Long.class));
    }
}