package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.PurchaseUseCaseFactory;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUserCase;
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
    public PurchaseClientUpdateUserCase purchaseClientUpdateUserCase(PurchaseClientWriterGateway writer) {
        return PurchaseUseCaseFactory.purchaseClientUpdateUserCase(writer);
    }

    @Bean
    public UpdatePurchaseUseCase updatePurchaseUseCase(FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase,
                                                       PurchaseClientUpdateUserCase purchaseClientUpdateUserCase,
                                                       PurchaseWriterGateway purchaseWriterGateway) {
        return PurchaseUseCaseFactory.updatePurchaseUseCase(findPurchaseByUUIDUseCase, purchaseClientUpdateUserCase, purchaseWriterGateway);
    }
}