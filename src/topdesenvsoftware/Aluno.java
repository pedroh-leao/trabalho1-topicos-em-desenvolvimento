
package topdesenvsoftware;

import java.time.LocalDate;

/**
 *
 * @author Pedro Oliveira e João Pedro Aniceto
 */
public class Aluno {
    private String nome, cpf, endereco, telefone, turma, programa;
    private int numeroMatricula;
    private LocalDate dataNascimento;
    private char sexo;
    private Departamento departPrincipal, departSecundario;
    
    public Aluno (){
        
    }
    
    public Aluno(String nome, String cpf, String end, String tel, String turma, String prog, int nMatricula, LocalDate dataNasc, char sexo){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = end;
        this.telefone = tel;
        this.turma = turma;
        this.programa = prog;
        this.sexo = sexo;
        this.numeroMatricula = nMatricula;
        this.dataNascimento = dataNasc;
    }
    
    public Aluno(String nome, String cpf, String end, String tel, String turma, String prog, int nMatricula, LocalDate dataNasc, char sexo, Departamento departPrincipal, Departamento departSecundario){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = end;
        this.telefone = tel;
        this.turma = turma;
        this.programa = prog;
        this.sexo = sexo;
        this.numeroMatricula = nMatricula;
        this.dataNascimento = dataNasc;
        this.departPrincipal = departPrincipal;
        this.departSecundario = departSecundario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String end) {
        this.endereco = end;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int nMatricula) {
        this.numeroMatricula = nMatricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNasc) {
        this.dataNascimento = dataNasc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Departamento getDepartPrincipal() {
        return departPrincipal;
    }

    public void setDepartPrincipal(Departamento departP) {
        this.departPrincipal = departP;
    }

    public Departamento getDepartSecundario() {
        return departSecundario;
    }

    public void setDepartSecundario(Departamento departS) {
        this.departSecundario = departS;
    }
}
