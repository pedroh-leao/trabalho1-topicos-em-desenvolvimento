/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topdesenvsoftware;

/**
 *
 * @author Pedro Oliveira e João Pedro Aniceto
 */
public class Curso {
    String nome, descricao;
    int numeroCurso, horasSemestrais, nivel;
    Departamento departResponsavel;
    
    public Curso(){
        
    }
    
    public Curso(String nome, String descricao, int numeroCurso, int horasSemestrais, int nivel){
        this.nome = nome;
        this.descricao = descricao;
        this.numeroCurso = numeroCurso;
        this.horasSemestrais = horasSemestrais;
        this.nivel = nivel;
    }
    
    public Curso(String nome, String descricao, int numeroCurso, int horasSemestrais, int nivel, Departamento departResponsavel){
        this.nome = nome;
        this.descricao = descricao;
        this.numeroCurso = numeroCurso;
        this.horasSemestrais = horasSemestrais;
        this.nivel = nivel;
        this.departResponsavel = departResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroCurso() {
        return numeroCurso;
    }

    public void setNumeroCurso(int numeroCurso) {
        this.numeroCurso = numeroCurso;
    }

    public int getHorasSemestrais() {
        return horasSemestrais;
    }

    public void setHorasSemestrais(int horasSemestrais) {
        this.horasSemestrais = horasSemestrais;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Departamento getDepartResponsavel() {
        return departResponsavel;
    }

    public void setDepartResponsavel(Departamento departResponsavel) {
        this.departResponsavel = departResponsavel;
    }
}
