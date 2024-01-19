package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.presenter.PresenterFactory;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresenterConfiguration {

    @Bean
    public PurchasePresenter purchasePresenter() {
        return PresenterFactory.purchasePresenter();
    }
}