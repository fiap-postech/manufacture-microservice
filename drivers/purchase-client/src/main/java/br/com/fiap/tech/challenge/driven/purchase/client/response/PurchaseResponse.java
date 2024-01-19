package br.com.fiap.tech.challenge.driven.purchase.client.response;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.rest.common.response.Response;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class PurchaseResponse extends Response {

    private String id;
    private PurchaseStatus status;
    private LocalDate date;
    private String code;
    private CustomerResponse customer;
    private List<PurchaseItemResponse> items;
}
