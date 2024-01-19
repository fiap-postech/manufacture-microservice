package br.com.fiap.tech.challenge.driven.purchase.client.response;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PurchaseItemResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -3104288659566784282L;

    private ProductResponse product;
    private Integer quantity;
}
