package com.fiap.parquimetro.dominio.estacionamento.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstacionamentoEncerradoDTO {
    public EstacionamentoEncerradoDTO(String status) {
        this.status = status;
    }

    @ApiModelProperty(value = "ID do endereco", example = "1", position = 1)
    private Long id;

    @ApiModelProperty(value = "Latitude", example = "-23º 33' 23.99 S", position = 1)
    @NotBlank(message = "A latitude deve ser preenchida")
    private String latitude;

    @ApiModelProperty(value = "Longitude", example = "-43º 39' 12.59 W", position = 1)
    @NotBlank(message = "A Longitude deve ser preenchida")
    private String longitude;

    @ApiModelProperty(value = "Modalidade", example = "POR_HORA", position = 1)
    @NotBlank(message = "A modalidade deve ser preenchida")
    private String modalidade;

    @ApiModelProperty(value = "Tempo em horas", example = "1", position = 1)
    private Long tempo;

    @ApiModelProperty(value = "Data de inicio", example = "2023-10-30 10:00:00", position = 1)
    @NotNull(message = "A data de inicio deve ser preenchida")
    private LocalDateTime datainicio;

    @ApiModelProperty(value = "Data de encerramento", example = "2023-10-30 11:00:00", position = 1)
    private LocalDateTime datafim;

    @ApiModelProperty(value = "Valor ", example = "7.00", position = 1)
    private Double valorTotal;

    @ApiModelProperty(value = "Status ", example = "Aguardando pagamento", position = 1)
    private String status;

    @ApiModelProperty(value = "Aviso ", example = "Encerrado dentro do tempo", position = 1)
    private String aviso;

}
