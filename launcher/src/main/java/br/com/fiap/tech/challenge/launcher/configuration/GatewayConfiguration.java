package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.gateway.purchase.PurchaseGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import br.com.fiap.tech.challenge.adapter.repository.PurchaseWriterRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public PurchaseReaderGateway purchaseReaderGateway(PurchaseReaderRepository repository) {
        return PurchaseGatewayFactory.purchaseReaderGateway(repository);
    }

    @Bean
    public PurchaseWriterGateway purchaseWriterGateway(PurchaseWriterRepository repository) {
        return PurchaseGatewayFactory.purchaseWriterGateway(repository);
    }
}
