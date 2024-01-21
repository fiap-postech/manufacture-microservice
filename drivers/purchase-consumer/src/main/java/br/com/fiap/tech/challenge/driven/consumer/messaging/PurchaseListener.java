package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.controller.purchase.CreatePurchaseController;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.driven.consumer.mapping.CreatePurchaseMapper;
import br.com.fiap.tech.challenge.driven.consumer.util.JsonUtil;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseListener {

    private final CreatePurchaseController createPurchaseController;
    private final CreatePurchaseMapper createPurchaseMapper;

    @SqsListener(queueNames = "${aws.sqs.manufacture-purchase-created-queue.name}")
    void listen(String message) {
        var purchaseDTO = JsonUtil.fromJsonString(message, PurchaseDTO.class);
        createPurchaseController.create(createPurchaseMapper.toDTO(purchaseDTO));
    }
}