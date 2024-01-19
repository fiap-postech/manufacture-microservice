package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.purchase.CreatePurchaseController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByStatusController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByUUIDController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.PurchaseControllerFactory;
import br.com.fiap.tech.challenge.adapter.controller.purchase.UpdatePurchaseController;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.application.usecase.purchase.CreatePurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByStatusUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.FindPurchaseByUUIDUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.UpdatePurchaseUseCase;
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

    @Bean
    public FindPurchaseByStatusController findPurchaseByStatusController(FindPurchaseByStatusUseCase useCase, PurchasePresenter presenter) {
        return PurchaseControllerFactory.findPurchaseByStatusController(useCase, presenter);
    }

    @Bean
    public UpdatePurchaseController updatePurchaseController(UpdatePurchaseUseCase useCase, PurchasePresenter presenter) {
        return PurchaseControllerFactory.updatePurchaseController(useCase, presenter);
    }
}