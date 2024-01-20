package br.com.fiap.tech.challenge.adapter.gateway.purchase;

import br.com.fiap.tech.challenge.adapter.repository.PurchaseReaderRepository;
import br.com.fiap.tech.challenge.application.gateway.PurchaseReaderGateway;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static br.com.fiap.tech.challenge.adapter.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseDTOFixture.waitingMakingPurchaseDTOModel;
import static br.com.fiap.tech.challenge.adapter.fixture.PurchaseFixture.waitingMakingPurchaseModel;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseReaderGatewayTest {

    @Mock
    private PurchaseReaderRepository repository;

    private PurchaseReaderGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = PurchaseGatewayFactory.purchaseReaderGateway(repository);
    }

    @Test
    void shouldReturnPurchaseByUuid() {
        var purchase = create(waitingMakingPurchaseModel());
        var purchaseDTO = create(waitingMakingPurchaseDTOModel());

        when(repository.readById(purchase.uuid().toString())).thenReturn(purchaseDTO);

        var response = gateway.readById(purchase.uuid());

        assertThat(response)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(purchase);

        verify(repository).readById(purchase.uuid().toString());
    }

    @Test
    void shouldReturnPurchasesByStatus() {
        var status = PurchaseStatus.WAITING_MAKING;
        var purchase = create(waitingMakingPurchaseModel());
        var purchaseDTOs = List.of(create(waitingMakingPurchaseDTOModel()));

        when(repository.readByStatus(status)).thenReturn(purchaseDTOs);

        var response = gateway.readByStatus(status);

        Assertions.assertThat(response)
                .isNotNull()
                .hasSizeGreaterThan(0)
                .usingRecursiveFieldByFieldElementComparator()
                .contains(purchase);

        verify(repository).readByStatus(status);
    }
}