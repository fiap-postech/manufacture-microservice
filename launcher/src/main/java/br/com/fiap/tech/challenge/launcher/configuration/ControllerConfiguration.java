package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.purchase.CreatePurchaseController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.PurchaseControllerFactory;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public CreatePurchaseController createPurchaseController(CreatePurchaseUseCase useCase, PurchasePresenter presenter) {
        return PurchaseControllerFactory.createPurchaseController(useCase, presenter);
    }

    @Bean
    public FindPurchaseByUUIDController findPurchaseByUUIDController(FindPurchaseByUUIDUseCase useCase, PurchasePresenter presenter) {
        return PurchaseControllerFactory.findPurchaseByUUIDController(useCase, presenter);
    }
}
