package br.com.fiap.tech.challenge.enterprise.entity;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.INVALID_PURCHASE_STATUS;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Purchase extends Entity {

    @Serial
    private static final long serialVersionUID = -9196907733871633595L;

    private final Customer customer;

    @NotNull
    private final PurchaseStatus status;

    @NotNull
    private final LocalDate date;

    @NotNull
    private final String code;

    @NotNull
    @NotEmpty
    @Valid
    private final List<PurchaseItem> items;

    @Builder(toBuilder = true)
    public Purchase(@Builder.ObtainVia(method = "uuid") UUID uuid,
                    Customer customer,
                    @NotNull PurchaseStatus status,
                    @NotNull LocalDate date,
                    @NotNull String code,
                    @NotNull List<PurchaseItem> items) {
        super(uuid);

        this.customer = customer;
        this.status = status;
        this.date = date;
        this.code = code;
        this.items = items;

        validate();
    }

    public Purchase updateStatus(PurchaseStatus status) {
        if (!this.status().isNextStatusValid(status)) {
            throw new ApplicationException(INVALID_PURCHASE_STATUS, status);
        }
        return toBuilder().status(status).build();
    }
}