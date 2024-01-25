package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByStatusController;
import br.com.fiap.tech.challenge.adapter.controller.purchase.FindPurchaseByUUIDController;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.rest.mapping.PurchaseResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.QueryPurchaseResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacture")
@RequiredArgsConstructor
public class QueryPurchaseResource implements QueryPurchaseResourceDoc {

    private final PurchaseResponseMapper purchaseResponseMapper;

    private final FindPurchaseByUUIDController findPurchaseByUUIDController;
    private final FindPurchaseByStatusController findPurchaseByStatusController;

    @GetMapping("/{uuid}")
    public PurchaseResponse getByUUID(@PathVariable("uuid") String uuid) {
        return purchaseResponseMapper.toResponse(findPurchaseByUUIDController.get(uuid));
    }

    @GetMapping("/status/{status}")
    public List<PurchaseResponse> getByStatus(@PathVariable("status") PurchaseStatus status) {
        return findPurchaseByStatusController.get(status).stream().map(purchaseResponseMapper::toResponse).toList();
    }
}