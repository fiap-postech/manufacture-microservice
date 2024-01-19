package br.com.fiap.tech.challenge.driven.purchase.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("br.com.fiap.tech.challenge.driven.purchase.client")
@ComponentScan("br.com.fiap.tech.challenge.driven.purchase.client")
public class PurchaseClientConfiguration {
}