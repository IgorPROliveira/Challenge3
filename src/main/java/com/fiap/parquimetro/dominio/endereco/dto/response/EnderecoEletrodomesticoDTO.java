package com.fiap.parquimetro.dominio.endereco.dto.response;


import com.fiap.parquimetro.dominio.endereco.entitie.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEletrodomesticoDTO {

        private Long id;
        private String pais;
        private String estado;
        private String municipio;
        private String bairro;
        private String rua;
        private String cep;
        private String complemento;
        private Long idusuario;

        public EnderecoEletrodomesticoDTO(Endereco endereco) {
            this.id = endereco.getId();
            this.pais = endereco.getPais();
            this.estado = endereco.getEstado();
            this.municipio = endereco.getMunicipio();
            this.bairro = endereco.getBairro();
            this.rua = endereco.getRua();
            this.cep = endereco.getCep();
            this.complemento = endereco.getComplemento();
            this.idusuario = endereco.getIdusuario();
        }
    }


