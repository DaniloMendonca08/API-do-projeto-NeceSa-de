package br.com.project.NeceSaude.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.project.NeceSaude.model.Usuario;

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

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody Usuario usuario) {

        log.info("Cadastrando usuario...");

        usuarios.add(usuario);

        return ResponseEntity.ok().build();

    }

    @GetMapping("{email}")
    public ResponseEntity<Usuario> buscarCadastro(@PathVariable String email) {
        
        log.info("Buscando usuario pelo email...");

        for(Usuario usuario1 : usuarios) {
            if(usuario1.getEmail().equals(email)) {

                return ResponseEntity.ok(usuario1);
            }
        }

        return ResponseEntity.notFound().build();

    }
}
