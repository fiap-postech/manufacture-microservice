package br.com.fiap.tech.challenge.driven.consumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.tech.challenge.driven.consumer")
@EnableAsync
public class    PurchaseConsumerConfiguration {
}