package br.com.fiap.tech.challenge.driven.purchase.client.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CustomerResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -447066642189592390L;

    private String id;
    private String name;
}
