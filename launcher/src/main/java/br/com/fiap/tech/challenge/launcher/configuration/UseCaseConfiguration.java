package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.PurchaseUseCaseFactory;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUseCase;
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

    @Bean
    public PurchaseClientUpdateUseCase purchaseClientUpdateUseCase(PurchaseClientWriterGateway writer) {
        return PurchaseUseCaseFactory.purchaseClientUpdateUseCase(writer);
    }

    @Bean
    public UpdatePurchaseUseCase updatePurchaseUseCase(FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase,
                                                       PurchaseClientUpdateUseCase purchaseClientUpdateUseCase,
                                                       PurchaseWriterGateway purchaseWriterGateway) {
        return PurchaseUseCaseFactory.updatePurchaseUseCase(findPurchaseByUUIDUseCase, purchaseClientUpdateUseCase, purchaseWriterGateway);
    }
}