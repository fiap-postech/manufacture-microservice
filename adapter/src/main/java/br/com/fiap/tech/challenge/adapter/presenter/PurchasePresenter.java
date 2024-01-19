package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.application.util.ResponseList;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

import java.util.List;

public interface PurchasePresenter {

    PurchaseDTO present(Purchase purchase);

    ResponseList<PurchaseDTO> present(ResponseList<Purchase> list);

    List<PurchaseDTO> present(List<Purchase> list);

}