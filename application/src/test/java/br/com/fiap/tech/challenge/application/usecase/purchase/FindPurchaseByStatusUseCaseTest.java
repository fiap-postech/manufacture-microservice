package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.waitingMakingPurchaseModel;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPurchaseByStatusUseCaseTest {

    @Mock
    private PurchaseReaderGateway gateway;

    private FindPurchaseByStatusUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = PurchaseUseCaseFactory.findPurchaseByStatusUseCase(gateway);
    }

    @Test
    void shouldReturnPurchasesWhenExists() {
        var status = PurchaseStatus.WAITING_MAKING;
        var purchase = create(waitingMakingPurchaseModel());
        var purchases = List.of(purchase);

        when(gateway.readByStatus(status)).thenReturn(purchases);

        var response = useCase.get(status);

        assertThat(response)
                .isNotNull()
                .hasSizeGreaterThan(0)
                .contains(purchase);

        verify(gateway).readByStatus(status);
    }

    @Test
    void shouldReturnEmptyWhenNotExists() {
        when(gateway.readByStatus(any(PurchaseStatus.class))).thenReturn(List.of());

        var response = useCase.get(PurchaseStatus.WAITING_MAKING);

        assertThat(response)
                .isNotNull()
                .isEmpty();

        verify(gateway).readByStatus(any(PurchaseStatus.class));
    }
}