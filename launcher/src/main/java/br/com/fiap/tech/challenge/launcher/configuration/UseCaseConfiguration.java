package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.PurchaseUseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreatePurchaseUseCase createPurchaseUseCase(PurchaseWriterGateway writer) {
        return PurchaseUseCaseFactory.createPurchaseUseCase(writer);
    }

    @Bean
    public FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase(PurchaseReaderGateway gateway) {
        return PurchaseUseCaseFactory.findPurchaseByUUIDUseCase(gateway);
    }

    @Bean
    public FindPurchaseByStatusUseCase findPurchaseByStatusUseCase(PurchaseReaderGateway gateway) {
        return PurchaseUseCaseFactory.findPurchaseByStatusUseCase(gateway);
    }
}