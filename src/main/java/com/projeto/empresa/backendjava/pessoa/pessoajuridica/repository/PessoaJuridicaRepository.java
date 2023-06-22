package com.projeto.empresa.backendjava.pessoa.pessoajuridica.repository;

import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.dto.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica,Long> {
}
