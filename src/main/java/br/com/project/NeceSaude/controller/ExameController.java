package br.com.project.NeceSaude.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.NeceSaude.model.Exame;
import br.com.project.NeceSaude.repository.ExameRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("exames")
public class ExameController {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    ExameRepository repository;

    @PostMapping("cadastro")
    @ResponseStatus(CREATED)
    public Exame cadastrarExame(@RequestBody @Valid Exame exame) {
        
        log.info("Cadastrando exame");
        
        return repository.save(exame);
        
    }

    @GetMapping
    public List<Exame> getExames() { 
        log.info("Buscando exames...");

        return repository.findAll();
    }
    
    
}
