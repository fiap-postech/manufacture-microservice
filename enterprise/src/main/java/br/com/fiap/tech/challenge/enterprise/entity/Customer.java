package br.com.fiap.tech.challenge.enterprise.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.util.UUID;
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Customer extends Entity {

    @Serial
    private static final long serialVersionUID = 213659655671060163L;

    @NotBlank
    private final String name;

    @Builder(toBuilder = true)
    public Customer(@Builder.ObtainVia(method = "uuid") UUID uuid, String name) {
        super(uuid);

        this.name = name;

        validate();
    }
}
