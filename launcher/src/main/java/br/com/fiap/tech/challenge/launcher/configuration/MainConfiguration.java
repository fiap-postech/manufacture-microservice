package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.driven.dynamodb.config.DynamodbConfiguration;
import br.com.fiap.tech.challenge.driven.consumer.config.PurchaseConsumerConfiguration;
import br.com.fiap.tech.challenge.driven.purchase.client.config.PurchaseClientConfiguration;
import br.com.fiap.tech.challenge.rest.config.RestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestConfiguration.class,
        DynamodbConfiguration.class,
        PurchaseConsumerConfiguration.class,
        PurchaseClientConfiguration.class
})
public class MainConfiguration {
}