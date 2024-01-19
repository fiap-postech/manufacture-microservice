package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByUUIDController;
import br.com.fiap.tech.challenge.rest.mapping.PurchaseResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.PurchaseResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.response.PurchseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseResource implements PurchaseResourceDoc {

    private final PurchaseResponseMapper purchaseResponseMapper;
    private final FindPurchaseByUUIDController findPurchaseByUUIDController;

    @GetMapping("/{uuid}")
    public PurchseResponse getByUUID(@PathVariable("uuid") String uuid) {
        return purchaseResponseMapper.toResponse(findPurchaseByUUIDController.get(uuid));
    }
}