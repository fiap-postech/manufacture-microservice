package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseClientWriterGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUserCase;
import br.com.fiap.tech.challenge.application.usecase.purchase.client.PurchaseClientUpdateUserCaseImpl;
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

    public static PurchaseClientUpdateUserCase purchaseClientUpdateUserCase(PurchaseClientWriterGateway writer) {
        return new PurchaseClientUpdateUserCaseImpl(writer);
    }

    public static UpdatePurchaseUseCase updatePurchaseUseCase(FindPurchaseByUUIDUseCase findPurchaseByUUIDUseCase,
                                                              PurchaseClientUpdateUserCase purchaseClientUpdateUserCase,
                                                              PurchaseWriterGateway purchaseWriterGateway) {
        return new UpdatePurchaseUseCaseImpl(findPurchaseByUUIDUseCase, purchaseClientUpdateUserCase, purchaseWriterGateway);
    }
}