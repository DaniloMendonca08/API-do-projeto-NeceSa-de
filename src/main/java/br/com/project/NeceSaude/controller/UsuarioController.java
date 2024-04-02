package br.com.project.NeceSaude.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.project.NeceSaude.model.Usuario;
import br.com.project.NeceSaude.repository.UsuarioRepository;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("usuario")
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UsuarioRepository repository;

    @PostMapping("/cadastro")
    @ResponseStatus(CREATED)
    public Usuario cadastrarUsuario(@RequestBody @Valid Usuario usuario) {

        log.info("Cadastrando usuario...");

        return repository.save(usuario);
    }

    @GetMapping("{email}")
    public ResponseEntity<Usuario> buscarCadastro(@PathVariable String email) {
        
        log.info("Buscando usuario pelo email...");

        return repository
                    .findByEmail(email)
                    .map(ResponseEntity::ok) 
                    .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("{email}/{senha}")
    public ResponseEntity<Usuario> autenticarUsuario(@PathVariable String email, @PathVariable String senha) {
        
         var DBEmail = repository.findByEmail(email).isPresent();
         var DBSenha = repository.findBySenha(senha).isPresent();

         if (DBEmail == true  && DBSenha == true) {
             log.info("Usuario autenticado com sucesso!");
             return ResponseEntity.ok().build();
         } 

         log.info("Email ou senha estão incorretos");
         return ResponseEntity.notFound().build();

    }

    @PutMapping("/atualizar/{email}")
    public Usuario atualizarCadastro(@RequestBody @Valid Usuario usuario, @PathVariable String email) {
        
        log.info("Atualizando dados do usuário...");

        repository
        .findByEmail(email)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro com o email informado."));
    
        return repository.save(usuario);

    }


}
    
    