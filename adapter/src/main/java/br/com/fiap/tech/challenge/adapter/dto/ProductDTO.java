package br.com.fiap.tech.challenge.adapter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@Data
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1464909268054662495L;

    private String id;
    private String name;
    private String description;
}
