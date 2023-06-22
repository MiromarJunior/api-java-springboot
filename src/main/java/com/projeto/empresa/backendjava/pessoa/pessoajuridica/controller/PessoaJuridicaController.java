package com.projeto.empresa.backendjava.pessoa.pessoajuridica.controller;

import com.projeto.empresa.backendjava.pessoa.pessoajuridica.model.dto.PessoaJuridica;
import com.projeto.empresa.backendjava.pessoa.pessoajuridica.service.imp.PessoaJuridicaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
