package br.com.fiap.tech.challenge.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CreatePurchasePurchaseItemDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -3104288659566784282L;

    @NotNull
    private CreatePurchaseProductDTO product;

    @NotNull
    private Integer quantity;
}