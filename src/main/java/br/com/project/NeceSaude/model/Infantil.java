package br.com.project.NeceSaude.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Infantil extends Object {
      
    @Id
    private Long id_infantil;

    @CPF
    private String cpfRespo;
    
    @Size(min = 3, max = 50, message = "O nome deve ter pelo menos 3 caracteres")
    private String nome;

    @Past
    private LocalDate data_nascimento;

    @Size(min = 3, max = 20, message = "O peso deve ser válido!")
    private String peso;

    @Size(min = 4, max = 11, message = "A altura deve ser válida!")
    private String altura;

    @Size(min = 8, max = 9, message = "O sexo deve ser masculino ou feminino")
    private String sexo;

}
