package br.com.fiap.tech.challenge.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CreatePurchaseProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1464909268054662495L;

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}