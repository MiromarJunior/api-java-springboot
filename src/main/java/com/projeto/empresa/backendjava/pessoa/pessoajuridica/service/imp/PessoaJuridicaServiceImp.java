package com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.imp;


import com.projeto.empresa.backendjava.pessoa.pessoajuridica.dto.PessoaJuridicaDTO;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.PessoaJuridica;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.repository.PessoaJuridicaRepository;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.PessoaJuridicaService;
import com.projeto.empresa.backendjava.service.ServiceAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PessoaJuridicaServiceImp implements PessoaJuridicaService {

    @Autowired
    PessoaJuridicaRepository repo;





    @Override
    public List<PessoaJuridica> getAllPeju() {
        return repo.findAll();
    }

    @Override
    public PessoaJuridica createPeju(PessoaJuridicaDTO dto) {
        validaCnpj(dto.getPessoaCnpj());



        PessoaJuridica pessoa = new PessoaJuridica();
        BeanUtils.copyProperties(dto, pessoa,"pessoaCnpj","pessoaFonecelular","pessoaDtCadastro");
        pessoa.setPessoaCnpj(ServiceAPI.apenasNumeros(dto.getPessoaCnpj()));
        pessoa.setPessoaFoneCelular(ServiceAPI.apenasNumeros(dto.getPessoaFoneCelular()));
        pessoa.setPessoaDtCadastro(LocalDateTime.now());
        return repo.save(pessoa);
    }

    public void validaCnpj(String cnpj) {
        String cnpjString = cnpj.replaceAll("\\D+", "");
        if(repo.findByPessoaCnpj(cnpjString).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Erro ao Cadastrar ou Atualizar Pessoa - CNPJ já Cadastrado: ");
        }
    }
}
