package com.projeto.empresa.backendjava.pessoa.pessoajuridica.service;

import com.projeto.empresa.backendjava.pessoa.pessoajuridica.dto.PessoaJuridicaDTO;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.PessoaJuridica;

import java.util.List;

public interface PessoaJuridicaService {

    List<PessoaJuridica> getAllPeju();

    PessoaJuridica createPeju(PessoaJuridicaDTO pessoaJuridicaDTO);
}
