package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

import java.util.List;

class PurchasePresenterImpl implements PurchasePresenter {

    @Override
    public PurchaseDTO present(Purchase purchase) {
        return PurchaseMapper.INSTANCE.toDTO(purchase);
    }

    @Override
    public List<PurchaseDTO> present(List<Purchase> list) {
        return list.stream().map(PurchaseMapper.INSTANCE::toDTO).toList();
    }
}