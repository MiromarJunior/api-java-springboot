package com.projeto.empresa.backendjava.pessoa.pessoajuridica.dto;

import com.projeto.empresa.backendjava.pessoa.pessoaDTO.PessoaDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaJuridicaDTO extends PessoaDTO {

    @NotBlank(message ="Campo obrigatório")
    @CNPJ
    private String pessoaCnpj;

    private Long pessoaJuridicaId;

    @Size(max = 150, message = "'${validatedValue}' Tamanho máximo {max} caracteres.")
    private String pessoaNomeFantasia;

    @Size(max = 20, message = "'${validatedValue}' Tamanho máximo {max} caracteres.")
    private String pessoaIE;

    @Size(max = 20, message = "'${validatedValue}' Tamanho máximo {max} caracteres.")
    private String pessoaIM;


}
