package br.com.fiap.tech.challenge.application.usecase.purchase;

import br.com.fiap.tech.challenge.application.dto.CreatePurchaseDTO;
import br.com.fiap.tech.challenge.application.gateway.PurchaseWriterGateway;
import br.com.fiap.tech.challenge.application.util.Validations;
import br.com.fiap.tech.challenge.enterprise.entity.Customer;
import br.com.fiap.tech.challenge.enterprise.entity.Product;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import br.com.fiap.tech.challenge.enterprise.valueobject.Quantity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreatePurchaseUseCaseImpl implements CreatePurchaseUseCase {

    private final PurchaseWriterGateway purchaseWriterGateway;

    @Override
    public Purchase create(CreatePurchaseDTO dto) {
        Validations.validate(dto);
        var purchase = this.getPurchase(dto);
        return purchaseWriterGateway.write(purchase);
    }

    private Purchase getPurchase(CreatePurchaseDTO dto) {
        return Purchase.builder()
                .uuid(UUID.fromString(dto.getId()))
                .status(dto.getStatus())
                .date(dto.getDate())
                .code(dto.getCode())
                .customer(Customer.builder()
                        .uuid(UUID.fromString(dto.getCustomer().getId()))
                        .name(dto.getCustomer().getName())
                        .build())
                .items(dto.getItems().stream()
                        .map(item -> PurchaseItem.builder()
                                .quantity(Quantity.of(item.getQuantity()))
                                .product(Product.builder()
                                        .uuid(UUID.fromString(item.getProduct().getId()))
                                        .name(item.getProduct().getName())
                                        .description(item.getProduct().getDescription())
                                        .build())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}