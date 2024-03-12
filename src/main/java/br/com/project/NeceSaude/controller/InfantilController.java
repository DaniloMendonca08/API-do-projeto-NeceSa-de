package br.com.project.NeceSaude.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.NeceSaude.model.Infantil;

@RestController
@RequestMapping("infantil")
public class InfantilController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Infantil> infantis = new ArrayList<>();

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastrarInfantil(@RequestBody Infantil infantil) {

        log.info("Cadastrando infantil...");

        infantis.add(infantil);

        return ResponseEntity.ok().build();
    }

    @GetMapping("{cpfRespo}")
    public ResponseEntity<Infantil> buscarInfantil(@PathVariable Long cpfRespo) {

        log.info("Buscando cadastro com o CPF informado...");

        for(Infantil infantil : infantis) {
            if (infantil.getCpfRespo().equals(cpfRespo)) {

                return ResponseEntity.ok(infantil);
            }
        }

        return ResponseEntity.notFound().build();
    } 
    
}
