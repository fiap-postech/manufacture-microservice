package br.com.fiap.tech.challenge.enterprise.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.util.UUID;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends Entity {

    @Serial
    private static final long serialVersionUID = -556035981231420003L;

    @NotBlank
    private final String name;

    @NotBlank
    private final String description;

    @Builder(toBuilder = true)
    public Product(@Builder.ObtainVia(method = "uuid") UUID uuid, String name, String description) {
        super(uuid);

        this.name = name;
        this.description = description;

        validate();
    }
}