package set.ordenacao.listaAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if(!alunosSet.isEmpty()) {
            for (Aluno a : alunosSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunosSet.remove(alunoParaRemover);
        }
        else {
            System.out.println("O conjunto está vazio!");
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosOrdemAlfabetica = new TreeSet<>(alunosSet);
        if(!alunosSet.isEmpty()) {
            return alunosOrdemAlfabetica;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosNota = new TreeSet<>(new ComparatorNota());
        if(!alunosSet.isEmpty()) {
            alunosNota.addAll(alunosSet);
            return alunosNota;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunos() {
        return alunosSet;
    }

    // Testes
    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunosSet);

        gerenciadorAlunos.removerAluno(000L);
        gerenciadorAlunos.removerAluno(123457L);
        System.out.println(gerenciadorAlunos.alunosSet);

        gerenciadorAlunos.exibirAlunosPorNome();

        gerenciadorAlunos.exibirAlunosPorNota();
    }
}

