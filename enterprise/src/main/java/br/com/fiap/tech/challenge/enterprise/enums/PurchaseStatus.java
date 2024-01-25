package br.com.fiap.tech.challenge.enterprise.enums;

import static java.util.Objects.nonNull;

public enum PurchaseStatus {

    DELIVERED(null),
    MADE(DELIVERED),
    MAKING(MADE),
    WAITING_MAKE(MAKING);

    private final PurchaseStatus next;

    PurchaseStatus(PurchaseStatus next) {
        this.next = next;
    }

    public boolean isNextStatusValid(PurchaseStatus status) {
        return nonNull(this.next) && this.next == status;
    }
}