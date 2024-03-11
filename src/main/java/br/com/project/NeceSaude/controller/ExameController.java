package br.com.project.NeceSaude.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.NeceSaude.model.Exame;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("exames")
public class ExameController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    List<Exame> exames = new ArrayList<>();

    @PostMapping("cadastro")
    public ResponseEntity<Object> create(@RequestBody Exame exame) {
        
        log.info("Cadastrando exame");
        exames.add(exame);
        
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Exame> getExames() { 

        return exames;
    }
    
    
}
