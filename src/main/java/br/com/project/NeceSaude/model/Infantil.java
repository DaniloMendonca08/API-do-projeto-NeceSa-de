package br.com.project.NeceSaude.model;

public class Infantil {
      
    private Long cpfRespo;
    private String nome;
    private String idade;
    private String peso;
    private String altura;
    private String sexo;

    public Infantil(Long cpfRespo, String nome, String idade, String peso, String altura, String sexo) {
        this.cpfRespo = cpfRespo;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Long getCpfRespo() {
        return cpfRespo;
    }

    public void setCpfRespo(Long cpfRespo) {
        this.cpfRespo = cpfRespo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
