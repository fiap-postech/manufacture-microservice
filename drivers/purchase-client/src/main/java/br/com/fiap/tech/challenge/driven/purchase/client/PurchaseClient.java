package br.com.fiap.tech.challenge.driven.purchase.client;

import br.com.fiap.tech.challenge.driven.purchase.client.response.PurchaseResponse;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "PurchaseClient", url = "${purchase.host}")
public interface PurchaseClient {

    @PutMapping(value = "/{uuid}/{status}", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<PurchaseResponse> updateStatus(@PathVariable("uuid") String uuid,
                                                  @PathVariable("status") PurchaseStatus status);

}