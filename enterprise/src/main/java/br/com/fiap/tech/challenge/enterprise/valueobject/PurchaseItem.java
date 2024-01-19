package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.enterprise.entity.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class PurchaseItem extends ValueObject {

    @Serial
    private static final long serialVersionUID = -2071891141308689952L;

    @NotNull
    @Valid
    private final Product product;

    @NotNull
    @Valid
    private final Quantity quantity;

    @Builder(toBuilder = true)
    public PurchaseItem(@NotNull Product product,
                        @NotNull Quantity quantity) {
        this.product = product;
        this.quantity = quantity;

        validate();
    }
}