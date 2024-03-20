package br.com.project.NeceSaude.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exame extends Object{
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        
        private String nome;
        private LocalDate data;
        private Integer colesterolLDL;
        private Integer colesterolHDL;
        private Integer triglicerides;
        private Integer glicose;
}
