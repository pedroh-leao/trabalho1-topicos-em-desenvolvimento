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
class Departamento {
    String nome, telefoneSala;
    int codigo, numeroSala;
    
    public Departamento(){
        
    }
    
    public Departamento(String nome, int codigo, int numeroSala, String telefoneSala){
        this.nome = nome;
        this.codigo = codigo;
        this.numeroSala = numeroSala;
        this.telefoneSala = telefoneSala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getTelefoneSala() {
        return telefoneSala;
    }

    public void setTelefoneSala(String telefoneSala) {
        this.telefoneSala = telefoneSala;
    }
}
