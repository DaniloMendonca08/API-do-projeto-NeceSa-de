package br.com.project.NeceSaude.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.project.NeceSaude.model.Infantil;
import br.com.project.NeceSaude.repository.InfantilRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("infantil")
public class InfantilController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    InfantilRepository repository;

    @PostMapping("/cadastro")
    @ResponseStatus(CREATED)
    public Infantil cadastrarInfantil(@RequestBody @Valid Infantil infantil) {

        log.info("Cadastrando infantil...");

        return repository.save(infantil);

    }

    @GetMapping("{cpfRespo}")
    public ResponseEntity<Infantil> buscarInfantil(@PathVariable Long cpfRespo) {

        log.info("Buscando cadastro com o CPF informado...");

        return repository
                    .findById(cpfRespo)
                    .map(ResponseEntity::ok) 
                    .orElse(ResponseEntity.notFound().build());

    } 

    @PutMapping("/atualizar")
    public Infantil atualizarInfantil(@RequestBody @Valid Infantil infantil) {

        log.info("Atualizando dados infantis...");

        repository
        .findByCpfRespo(infantil.getCpfRespo())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro infantil com o CPF do responsável informado."));

        return repository.save(infantil);

    }
    
}
