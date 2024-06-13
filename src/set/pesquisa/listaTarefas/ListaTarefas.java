package set.pesquisa.listaTarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefasSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if(!tarefasSet.isEmpty()) {
            for(Tarefa t : tarefasSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefasSet.remove(tarefaParaRemover);
        }
        else {
            System.out.println("O conjunto está vazio");
        }
        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas() {
        if(!tarefasSet.isEmpty()) {
            System.out.println(tarefasSet);
        }
        else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public int contarTarefas() {
        return tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if(t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if(!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        if(!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                    break;
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if(!tarefasSet.isEmpty()) {
            for (Tarefa t : tarefasSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                    break;
                }
            }
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void limparListaTarefas() {
        if(!tarefasSet.isEmpty()) {
            tarefasSet.clear();
        }
        else {
            System.out.println("O conjunto já está vazio!");
        }
    }

    // Testes
    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        System.out.println(listaTarefas.obterTarefasConcluidas());

        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
