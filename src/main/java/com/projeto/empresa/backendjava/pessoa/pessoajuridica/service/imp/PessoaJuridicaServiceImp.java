package com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.imp;


import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.dto.PessoaJuridica;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.repository.PessoaJuridicaRepository;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaJuridicaServiceImp implements PessoaJuridicaService {

    @Autowired
    PessoaJuridicaRepository repo;
    @Override
    public List<PessoaJuridica> getAllPeju() {
        return repo.findAll();
    }
}
