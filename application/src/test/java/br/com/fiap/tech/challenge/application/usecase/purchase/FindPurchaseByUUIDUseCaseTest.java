package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static br.com.fiap.tech.challenge.application.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.application.fixture.PurchaseFixture.waitingMakingPurchaseModel;
import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_CLIENT_NOT_FOUND_BY_UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPurchaseByUUIDUseCaseTest {

    @Mock
    private PurchaseReaderGateway gateway;

    private FindPurchaseByUUIDUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = PurchaseUseCaseFactory.findPurchaseByUUIDUseCase(gateway);
    }

    @Test
    void shouldReturnPurchaseWhenExists() {
        var purchase = create(waitingMakingPurchaseModel());

        when(gateway.readById(any(UUID.class))).thenReturn(purchase);

        var response = useCase.get(purchase.uuid());

        assertThat(response)
                .isNotNull()
                .isEqualTo(purchase);

        verify(gateway).readById(any(UUID.class));
    }

    @Test
    void shouldThrowsExceptionWhenNotExists() {
        var uuid = UUID.fromString("6a568870-3784-4b7c-a55c-bd005873046a");
        var exception = new ApplicationException(PURCHASE_CLIENT_NOT_FOUND_BY_UUID);

        when(gateway.readById(any(UUID.class))).thenThrow(exception);

        assertThatThrownBy(() -> useCase.get(uuid))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(exception.getMessage());

        verify(gateway).readById(any(UUID.class));
    }
}