package br.com.fiap.tech.challenge.application.dto;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreatePurchaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3410518373165012648L;

    @NotBlank
    private String id;

    @NotNull
    private PurchaseStatus status;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String code;

    @NotNull
    private CreatePurchaseCustomerDTO customer;

    @NotNull
    private List<CreatePurchasePurchaseItemDTO> items;
}