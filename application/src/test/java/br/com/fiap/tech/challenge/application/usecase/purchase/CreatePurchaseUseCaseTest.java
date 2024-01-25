package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static br.com.fiap.tech.challenge.application.fixture.CreatePurchaseDTOFixture.createPurchaseDTOModel;
import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.waitingMakePurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePurchaseUseCaseTest {

    @Mock
    private PurchaseWriterGateway purchaseWriterGateway;

    private CreatePurchaseUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = PurchaseUseCaseFactory.createPurchaseUseCase(purchaseWriterGateway);
    }

    @Test
    void shouldCreatePurchase() {
        var purchase = create(waitingMakePurchaseModel());
        var createPurchaseDTO = create(createPurchaseDTOModel());

        when(purchaseWriterGateway.save(any(Purchase.class)))
                .thenAnswer(i -> Arrays.stream(i.getArguments()).findFirst().orElseThrow());

        var response = useCase.create(createPurchaseDTO);

        assertThat(response).usingRecursiveComparison().isEqualTo(purchase);

        verify(purchaseWriterGateway).save(any(Purchase.class));
    }
}