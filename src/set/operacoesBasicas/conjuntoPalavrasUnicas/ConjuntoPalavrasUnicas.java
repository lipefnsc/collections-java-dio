package set.operacoesBasicas.conjuntoPalavrasUnicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavrasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        String palavraParaRemover = null;
        if(!palavrasSet.isEmpty()) {
            if (palavrasSet.contains(palavra)) {
                palavrasSet.remove(palavra);
            }
            else {
                System.out.println("Palavra não encontrada no conjunto!");
            }
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavrasSet.isEmpty()) {
            System.out.println(palavrasSet);
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    // Testes
    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();

        System.out.println("Existem essas palavras no set: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        conjuntoPalavras.adicionarPalavra("Cachorro");
        conjuntoPalavras.adicionarPalavra("Gato");
        conjuntoPalavras.adicionarPalavra("Cavalo");

        System.out.println("Existem essas palavras no set: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        conjuntoPalavras.removerPalavra("Gato");

        System.out.println("Existem essas palavras no set: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        System.out.println("A palavra 'Cachorro' está no conjunto? " + conjuntoPalavras.verificarPalavra("Cachorro"));
        System.out.println("A palavra 'Gato' está no conjunto? " + conjuntoPalavras.verificarPalavra("Gato"));

        conjuntoPalavras.exibirPalavrasUnicas();
    }
}
