package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseUseCaseFactory {

    public static CreatePurchaseUseCase createPurchaseUseCase(PurchaseWriterGateway writer) {
        return new CreatePurchaseUseCaseImpl(writer);
    }

    public static FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase(PurchaseReaderGateway gateway) {
        return new FindPurchaseByUUIDUseCaseImpl(gateway);
    }
}