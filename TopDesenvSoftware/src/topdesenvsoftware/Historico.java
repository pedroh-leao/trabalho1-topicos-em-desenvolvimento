
package topdesenvsoftware;

import java.util.ArrayList;

/**
 *
 * @author Pedro Oliveira e João Pedro Aniceto
 */
public class Historico {
    private Aluno aluno;
    private ArrayList<Disciplina> disciplinas = new ArrayList();
    private ArrayList<String> conceito = new ArrayList();
    private ArrayList<Integer> notaNumerica = new ArrayList();
    
    public Historico(){
        
    }
    
    public Historico(Aluno aluno, Disciplina disciplina, String conceito, int notaNumerica){
        this.aluno = aluno;
        this.disciplinas.add(disciplina);
        this.conceito.add(conceito);
        this.notaNumerica.add(notaNumerica);
    }
    
    public void adicionarDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    
    public void adicionarConceito(String conceito){
        this.conceito.add(conceito);
    }
    
    public void adicionarNotaNumerica(int notaNumerica){
        this.notaNumerica.add(notaNumerica);
    }
    
    int posicao;
    public void removerDisciplina(Disciplina disciplina){
        this.disciplinas.remove(disciplina);
        posicao = this.disciplinas.indexOf(disciplina);
    }
    
    public void removerConceito(){
        this.conceito.remove(posicao);
    }
    
    public void removerNotaNumerica(){
        this.notaNumerica.remove(posicao);
    }    

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(int posicao, Disciplina disciplina) {
        this.disciplinas.set(posicao, disciplina);
    }

    public ArrayList<String> getConceito() {
        return conceito;
    }

    public void setConceito(int posicao, String conceito) {
        this.conceito.set(posicao, conceito);
    }

    public ArrayList<Integer> getNotaNumerica() {
        return notaNumerica;
    }

    public void setNotaNumerica(int posicao, int notaNumerica) {
        this.notaNumerica.set(posicao, notaNumerica);
    }
}
