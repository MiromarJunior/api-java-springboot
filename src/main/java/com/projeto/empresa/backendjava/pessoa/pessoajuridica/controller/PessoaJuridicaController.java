package com.projeto.empresa.backendjava.pessoa.pessoajuridica.controller;

import com.projeto.empresa.backendjava.pessoa.pessoafisica.dto.PessoaFisicaDTO;
import com.projeto.empresa.backendjava.pessoa.pessoafisica.model.PessoaFisica;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.dto.PessoaJuridicaDTO;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.PessoaJuridica;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.imp.PessoaJuridicaServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoaJuridica")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaServiceImp service;

    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> getAllPeju(){
        List<PessoaJuridica> pessoas = service.getAllPeju();
        return ResponseEntity.status(200).body(pessoas);
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> savEntity(@Valid @RequestBody PessoaJuridicaDTO dto){
        PessoaJuridica pessoa =  service.createPeju(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getPessoaJuridicaId())
                .toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }


}
