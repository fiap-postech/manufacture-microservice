package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUseCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUseCaseImpl;
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

    public static FindPurchaseByStatusUseCase findPurchaseByStatusUseCase(PurchaseReaderGateway gateway) {
        return new FindPurchaseByStatusUseCaseImpl(gateway);
    }

    public static PurchaseClientUpdateUseCase purchaseClientUpdateUseCase(PurchaseClientWriterGateway writer) {
        return new PurchaseClientUpdateUseCaseImpl(writer);
    }

    public static UpdatePurchaseUseCase updatePurchaseUseCase(FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase,
                                                              PurchaseClientUpdateUseCase purchaseClientUpdateUseCase,
                                                              PurchaseWriterGateway purchaseWriterGateway) {
        return new UpdatePurchaseUseCaseImpl(findPurchaseByUUIDUseCase, purchaseClientUpdateUseCase, purchaseWriterGateway);
    }
}