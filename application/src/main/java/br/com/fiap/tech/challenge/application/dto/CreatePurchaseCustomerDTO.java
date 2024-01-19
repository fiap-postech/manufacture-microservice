package br.com.fiap.tech.challenge.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CreatePurchaseCustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -447066642189592390L;

    @NotBlank
    private String id;

    @NotBlank
    private String name;
}