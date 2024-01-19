package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import br.com.fiap.tech.challenge.rest.resource.response.PurchseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Produção", description = "API responsável pelo gerenciamento da produção dos Pedidos")
public interface UpdatePurchaseResourceDoc {

    @Operation(
            summary = "Atualiza o status de um pedido",
            description = "Atualiza o status de produção de um pedido",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso na atualização do pedido", content = { @Content(schema = @Schema(implementation = PurchseResponse.class), mediaType = "application/json") }),
                    @ApiResponse(responseCode = "400", description = "O UUID ou o status do pedido são inválidos", content = { @Content(schema = @Schema()) })
            }
    )
    PurchseResponse updateStatus(@Parameter(description = "UUID do pedido a ser atualizado", required = true) String uuid,
                                 @Parameter(description = "Status a ser definido no pedido", required = true) PurchaseStatus status);
}