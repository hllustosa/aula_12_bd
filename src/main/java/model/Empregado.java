package model;

public class Empregado {

    private int matricula;
    private String nome;
    private String endereco;
    private float salario;
    private int coddep;
    private String cargo;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCoddep() {
        return coddep;
    }

    public void setCoddep(int coddep) {
        this.coddep = coddep;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                ", coddep=" + coddep +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
