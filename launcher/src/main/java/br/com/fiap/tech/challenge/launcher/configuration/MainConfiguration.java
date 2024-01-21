package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.config.DynamodbConfiguration;
import br.com.fiap.tech.challenge.driven.consumer.config.PurchaseConsumerConfiguration;
import br.com.fiap.tech.challenge.driven.purchase.client.config.PurchaseClientConfiguration;
import br.com.fiap.tech.challenge.rest.config.RestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
@Import({
        RestConfiguration.class,
        DynamodbConfiguration.class,
        PurchaseConsumerConfiguration.class,
        PurchaseClientConfiguration.class
})
public class MainConfiguration {

}