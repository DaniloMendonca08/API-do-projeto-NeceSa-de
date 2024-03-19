package br.com.project.NeceSaude.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Infantil extends Object {
      
    @Id
    private Long cpfRespo;
    
    private String nome;
    private String idade;
    private String peso;
    private String altura;
    private String sexo;

}
