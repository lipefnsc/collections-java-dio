package set.ordenacao.cadastroProdutos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(nome, cod, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosOrdemAlfabetica = new TreeSet<>(produtosSet);
        if(!produtosSet.isEmpty()) {
            return produtosOrdemAlfabetica;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        if(!produtosSet.isEmpty()) {
            produtosPorPreco.addAll(produtosSet);
            return produtosPorPreco;
        }
        else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    // Testes
    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        System.out.println(cadastroProdutos.produtosSet);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
