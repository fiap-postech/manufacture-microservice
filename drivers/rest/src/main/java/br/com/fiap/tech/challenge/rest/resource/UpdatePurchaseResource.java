package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.purchase.UpdatePurchaseController;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.rest.mapping.PurchaseResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.UpdatePurchaseResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacture")
@RequiredArgsConstructor
public class UpdatePurchaseResource implements UpdatePurchaseResourceDoc {

    private final PurchaseResponseMapper purchaseResponseMapper;
    private final UpdatePurchaseController updatePurchaseController;

    @PutMapping("/{uuid}/{status}")
    public PurchaseResponse updateStatus(@PathVariable("uuid") String uuid,
                                         @PathVariable("status") PurchaseStatus status) {
        return purchaseResponseMapper.toResponse(updatePurchaseController.update(uuid, status));
    }
}