/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topdesenvsoftware;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pedro Oliveira e João Pedro Aniceto
 */
public class Menu {
    static Scanner sNumero = new Scanner(System.in); //scanner para números
    static Scanner sString = new Scanner(System.in); //scanner para Strings
    static ArrayList<Disciplina> disciplinas = new ArrayList();
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    static ArrayList<Historico> historicos = new ArrayList<Historico>();
    static ArrayList<Curso> cursos = new ArrayList<Curso>();
    
    public static void cadastrarDisciplina(Curso curso){
        System.out.println("Digite o nome da disciplina: ");
        String nome = sString.nextLine();
        
        System.out.println("Digite o número da Disciplina: ");
        int n = sNumero.nextInt();
        
        System.out.println("Digite o nome do professor dessa disciplina: ");
        String nomeProfessor = sString.nextLine();
        
        int ano, semestre;
        LocalDate date = LocalDate.now();
        ano = date.getYear();
        if(date.getMonthValue() <= 6){
            semestre = 1;
        }
        else{
            semestre = 2;
        }
        
        disciplinas.add(new Disciplina(nomeProfessor, nome, semestre, ano, n, curso));
        System.out.println("Disciplina cadastrada!");
    }
    
    public static void cadastrarAluno(){ //método apenas para o programa ficar mais completo (não foi solicitado no pdf)
        System.out.println("Digite o nome do(a) aluno(a):");
        String nome = sString.nextLine();

        System.out.println("Digite a matricula do(a) aluno(a):");
        int numeroMatricula = sNumero.nextInt();

        System.out.println("Digite o CPF:");
        String cpf = sString.nextLine();

        System.out.println("Digite o endereço:");
        String endereco = sString.nextLine();

        System.out.println("Digite o telefone:");
        String telefone = sString.nextLine();

        System.out.println("Digite a data de nascimento:");
        String dataNascimento = sString.nextLine();
        LocalDate dataNasc; //variável para armazenar data formatada
        dataNasc = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Digite o sexo:");
        char sexo = sString.next().charAt(0);

        System.out.println("Digite a turma:");
        String turma = sString.nextLine();

        System.out.println("Digite o programa:");
        String programa = sString.nextLine();
        
        alunos.add(new Aluno(nome, cpf, endereco, telefone, turma, programa, numeroMatricula, dataNasc, sexo));
        
        System.out.println("Aluno cadastrado!");
    }
    
    public static void matricularAlunoEmDisciplina(){
        System.out.println("Digite o nome do aluno que deseja matricular: ");
        String nomeAluno = sString.nextLine();
        System.out.println("Digite a disciplina que deseja matricular o aluno: ");
        String nomeDisciplina = sString.nextLine();
        int cont=0, posicao=0;
        Aluno aluno=null;
        Disciplina disciplina = null;
        
        do{ //procura o aluno que será matriculado
            for (Aluno a : alunos){
                if(a.getNome().equals(nomeAluno)){
                    posicao = cont;
                    aluno = a;
                }
                cont++;
            }
        }while(aluno == null);
        
        do{ //procura qual a disciplina que o aluno será matriculado
            for(Disciplina d : disciplinas){
                if(d.getNomeDisciplina().equals(nomeDisciplina)){
                    disciplina = d;
                }
            }
        }while(disciplina == null);
        
        historicos.get(posicao).adicionarConceito(null);
        historicos.get(posicao).adicionarDisciplina(disciplina);
        historicos.get(posicao).adicionarNotaNumerica(0);
        
        System.out.println("Aluno matriculado na disciplina!");
    }
    
    public static void registrarNota(){
        System.out.println("Digite a disciplina que deseja definir a nota do aluno: ");
        String disciplina = sString.nextLine();
        
        System.out.println("Digite o aluno que deseja atribuir a nota: ");
        String aluno = sString.nextLine();
        
        System.out.println("Digite a nota do aluno " + aluno + " na disciplina de " + disciplina + ": ");
        int notaNumerica = sNumero.nextInt();
        
        String conceito = null;
        if(notaNumerica <=10){
            conceito = "F";
        }
        else if(notaNumerica <= 20){
            conceito = "E";
        }
        else if(notaNumerica <= 40){
            conceito = "D";
        }
        else if(notaNumerica <= 60){
            conceito = "C";
        }
        else if(notaNumerica <= 80){
            conceito = "B";
        }
        else{
            conceito = "A";
        }
        
        for(Historico h : historicos){
            if(h.getAluno().getNome().equals(aluno)){ //procura o aluno para o qual a nota será atribuida
                int posicao=0;
                for(int cont=0; cont<h.getDisciplinas().size();cont++){
                    if(h.getDisciplinas().get(cont).getNomeDisciplina().equals(disciplina)){ //procura a disciplina para a qual será definida a nota do aluno
                        posicao=cont;
                    }
                }

                h.setNotaNumerica(posicao, notaNumerica);
                h.setConceito(posicao, conceito);
                
                System.out.println("Nota atribuída ao aluno!");
            }
        }
    }
    
    public static void listarAprovadosEReprovados(){
        System.out.println("Digite a disciplina que deseja ver a lista de aprovados e reprovados: ");
        String disciplina = sString.nextLine();
        
        for(Historico h : historicos){
            for(int cont=0; cont<h.getDisciplinas().size();cont++){ //procura a disciplina que o usuário deseja ver a lista de aprovados e reprovados
                if(h.getDisciplinas().get(cont).getNomeDisciplina().equals(disciplina)){
                    if(h.getNotaNumerica().get(cont)<60){
                        System.out.println(h.getAluno().getNome() + " - Reprovado");
                    }
                    else{
                        System.out.println(h.getAluno().getNome() + " - Aprovado");
                    }
                }
            }
        }
    }
    
    public static void main(String[] args){
        Departamento d1 = new Departamento("Departamento de Informática", 356008, 12, "2233-5457");
        Departamento d2 = new Departamento("Departamento de Administração", 356009, 13, "2233-5458");

        cursos.add(new Curso("Curso Técnico em Informática", "Curso técino integral em Informática", 3422, 84, 2, d1));
        cursos.add(new Curso("Bacharelado em Administração", "Curso Bacharelado em Administração no período noturno", 3487, 58, 1, d2));

        disciplinas.add(new Disciplina("Kdu", "Programação 1", 1, 2021, 4, cursos.get(0)));
        disciplinas.add(new Disciplina("Daniela", "Programação OO", 1, 2021, 22, cursos.get(0)));
        disciplinas.add(new Disciplina("Saulo", "Tópicos em Desenvolvimento", 1, 2021, 16, cursos.get(0)));
        disciplinas.add(new Disciplina("Marina", "Gestão empresarial", 1, 2021, 7, cursos.get(1)));
        disciplinas.add(new Disciplina("Mariano", "Gestão Ambiental", 1, 2021, 13, cursos.get(1)));
        
        alunos.add(new Aluno("João Pedro", "123456789", "Rua paixão n°524, Ouro Branco", "9374-8392", "Calouro", "graduação", 2209325, LocalDate.of(2003,11,3), 'm', d1, null));
        alunos.add(new Aluno("Mariana", "987654321", "Rua paixão n°729, Ouro Branco", "9824-2463", "Veterano", "mestrado", 2210587, LocalDate.of(2005,10,21), 'f', d2, null));
        alunos.add(new Aluno("Pedro Henrique", "159753456", "Rua Jorge Alves n°1846, Ouro Branco", "6584-8568", "graduado", "doutorado", 2209305, LocalDate.of(2004,3,19), 'm', d1, null));
        alunos.add(new Aluno("Maria Eduarda", "753951123", "Rua Aurora n°2325, Ouro Branco", "9117-1486", "Calouro", "graduação", 2209398, LocalDate.of(2003,12,22), 'f', d2, null));
        alunos.add(new Aluno("Juliana", "852741369", "Av Silva Campos n°922, Ouro Branco", "9321-4502", "graduado", "doutorado", 22010622, LocalDate.of(2005,3,14), 'f', d1, null));
        alunos.add(new Aluno("Marcelo", "321745986", "Av Faria Lima n°1864, São Paulo", "9146-2148", "Veterano", "mestrado ", 2401236, LocalDate.of(1999,5,30), 'm', d2, null));
        alunos.add(new Aluno("Henrique", "985632478", "Rua X de maio n°1524, Ouro Branco", "9214-5824", "Calouro", "graduação", 2402145, LocalDate.of(1997,11,14), 'm', d1, null));
        alunos.add(new Aluno("Izabella", "349726149", "Av pelotão n°1654, Belo Horizonte", "9266-5796", "Veterano", "mestrado", 2403579, LocalDate.of(2000,9,3), 'f', d2, null));
        
        historicos.add(new Historico(alunos.get(0), disciplinas.get(0), null, 0));
        historicos.add(new Historico(alunos.get(1), disciplinas.get(4), null, 0));
        historicos.add(new Historico(alunos.get(2), disciplinas.get(2), null, 0));
        historicos.add(new Historico(alunos.get(3), disciplinas.get(2), null, 0));
        historicos.add(new Historico(alunos.get(4), disciplinas.get(1), null, 0));
        historicos.add(new Historico(alunos.get(5), disciplinas.get(0), null, 0));
        historicos.add(new Historico(alunos.get(6), disciplinas.get(3), null, 0));
        historicos.add(new Historico(alunos.get(7), disciplinas.get(4), null, 0));
        
        int n = 0;
        do{
            System.out.println("Digite o número do que deseja fazer: \n1- Cadastrar disciplina \n2- Cadastrar aluno \n3- Matricular aluno em disciplina \n4- Registro de nota de um aluno na disciplina "
                    + "\n5- Listar alunos aprovados e reprovados em uma disciplina \n6- Sair");
            n = sNumero.nextInt();
            if(n>6 || n<0){
                System.out.println("Digite um número válido!");
            }else{
                switch(n){
                    case 1:
                        System.out.println("Digite o curso correspondente a essa disciplina: ");
                        String nomeCurso = sString.nextLine();
                        Curso curso = null;
                        for(Curso c : cursos){
                            if(c.getNome().equals(nomeCurso)){
                                curso = c;
                            }
                        }
                        cadastrarDisciplina(curso);
                        break;
                    case 2:
                        cadastrarAluno();
                        break;
                    case 3:
                        matricularAlunoEmDisciplina();
                        break;
                    case 4:
                        registrarNota();
                        break;
                    case 5:
                        listarAprovadosEReprovados();
                        break;
                    default:
                        break;
                }
            }
        }while(n!=6);
    }
}
