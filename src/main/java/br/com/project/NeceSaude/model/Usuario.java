package br.com.project.NeceSaude.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Usuario extends Object {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CPF   
    private String cpf;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 3, max = 50, message = "O nome deve ter pelo menos 3 caracteres")
    private String nome;

    @Past
    private LocalDate data_nascimento;

    @Email
    private String email;

    @Size(min = 8, max = 15, message = "A senha deve conter no mínimo 8 caracteres")
    private String senha;
}
