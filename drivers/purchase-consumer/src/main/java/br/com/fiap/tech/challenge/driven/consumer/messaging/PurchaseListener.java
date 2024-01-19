package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.controller.purchase.CreatePurchaseController;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.driven.consumer.mapping.CreatePurchaseMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseListener {

    private final CreatePurchaseController createPurchaseController;
    private final CreatePurchaseMapper createPurchaseMapper;

    @SqsListener(queueNames = "${aws.sqs.manufacture-purchase-created-queue.name}")
    void listen(PurchaseDTO purchaseDTO) {
        System.out.println("purchaseDTO: " + purchaseDTO);
        var createPurchaseDTO = createPurchaseController.create(createPurchaseMapper.toDTO(purchaseDTO));
        System.out.println("createPurchaseDTO: " + createPurchaseDTO);
    }
}