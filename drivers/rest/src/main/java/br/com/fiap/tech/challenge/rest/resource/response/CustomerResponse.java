package br.com.fiap.tech.challenge.rest.resource.response;

import br.com.fiap.tech.challenge.rest.common.response.Response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Representação de um Cliente")
public class CustomerResponse extends Response {

    @Schema(description = "Identificador do Cliente", example = "39caa818-746b-4b42-b51a-05101dce8829")
    private String id;

    @Schema(description = "Nome Completo do Cliente", example = "Luke Skywalker")
    private String name;
}
