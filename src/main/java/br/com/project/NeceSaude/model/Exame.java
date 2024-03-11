package br.com.project.NeceSaude.model;

import java.util.Random;

public record Exame (Long id, String nome, String data, Integer colesterolLDL, Integer colesterolHDL, Integer triglicerides, Integer glicose ){
    
    public Exame(Long id, String nome, String data, Integer colesterolLDL, Integer colesterolHDL, Integer triglicerides, Integer glicose ) {

        this.id = Math.abs( new Random().nextLong() );
        this.nome = nome;
        this.data = data;
        this.colesterolLDL = colesterolLDL;
        this.colesterolHDL = colesterolHDL;
        this.triglicerides = triglicerides;
        this.glicose = glicose;
    }
}
