package br.com.project.NeceSaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario extends Object {
    
    @Id
    private Long cpf;

    private String nome;
    private int idade;
    private String email;
    private String senha;
}
