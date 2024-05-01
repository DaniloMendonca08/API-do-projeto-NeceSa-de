package br.com.project.NeceSaude.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Exame extends Object{
    
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        
        @Pattern(
        regexp = "^(EXAME DE SANGUE|Exame de sangue|exame de sangue)$",
        message = "Tipo inválido. Deve ser EXAME DE SANGUE|Exame de sangue|exame de sangue"
        )
        private String nome;

        @Past
        private LocalDate data;

        @Digits(integer = 3, fraction = 0, message = "{exame.colesterolLDL.digits}")
        @Min(value = 10, message = "{exame.colesterolLDL.min}")
        private Integer colesterolLDL;

        @Digits(integer = 3, fraction = 0, message = "{exame.colesterolHDL.digits}")
        @Min(value = 10, message = "{exame.colesterolHDL.min}")
        private Integer colesterolHDL;

        @Digits(integer = 3, fraction = 0, message = "{exame.triglicerides.digits}")
        @Min(value = 10, message = "{exame.triglicerides.min}")
        private Integer triglicerides;
 
        @Digits(integer = 3, fraction = 0, message = "{exame.glicose.digits}")
        @Min(value = 10, message = "{exame.glicose.min}")
        private Integer glicose;

        @ManyToOne //um usuário pode ter varios exames, mas um exame pertence apenas a um usuário
        private Usuario usuario;
}
