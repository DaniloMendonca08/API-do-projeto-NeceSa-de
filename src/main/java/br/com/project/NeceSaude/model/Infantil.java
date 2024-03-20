package br.com.project.NeceSaude.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Infantil extends Object {
      
    @Id
    private Long cpfRespo;
    
    private String nome;
    private LocalDate data_nascimento;
    private String peso;
    private String altura;
    private String sexo;

}
