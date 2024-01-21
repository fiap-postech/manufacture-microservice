package br.com.fiap.tech.challenge.driven.consumer.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.tech.challenge.driven.consumer")
@EnableAsync
public class PurchaseConsumerConfiguration {

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
    }
}
