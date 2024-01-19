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
public interface QueryPurchaseResourceDoc {

    @Operation(
            summary = "Retorna um pedido pelo UUID",
            description = "Busca o pedido registrado no banco de dados pelo UUID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso um pedido de acordo com a requisição", content = { @Content(schema = @Schema(implementation = PurchseResponse.class), mediaType = "application/json") }),
                    @ApiResponse(responseCode = "400", description = "O UUID do pedido fornecido não foi encontrado", content = { @Content(schema = @Schema()) })
            }
    )
    PurchseResponse getByUUID(@Parameter(description = "UUID do pedido a ser pesquisado", required = true) String uuid);

    @Operation(
            summary = "Retorna os pedidos pelo status",
            description = "Busca os pedidos registrados no banco de dados pelo status",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK - Retorno em caso de sucesso na solicitação de busca de pedidos por status", content = { @Content(schema = @Schema(implementation = PurchseResponse.class), mediaType = "application/json") }),
                    @ApiResponse(responseCode = "400", description = "O status do pedido fornecido não é válido", content = { @Content(schema = @Schema()) })
            }
    )
    List<PurchseResponse> getByStatus(@Parameter(description = "Status dos pedidos a serem pesquisados", required = true) PurchaseStatus status);
}