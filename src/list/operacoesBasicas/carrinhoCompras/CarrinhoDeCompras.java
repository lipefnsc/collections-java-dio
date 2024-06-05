package list.operacoesBasicas.carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemsParaRemover.add(i);
                }
            }
            itemList.removeAll(itemsParaRemover);
        }
        else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double soma = 0.0;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                soma += i.getPreco() * i.getQuantidade();
            }
        return soma;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(itemList);
        }
        else {
            System.out.println("A lista está vazia!");
        }
    }

    // Testes
    public static void main(String[] args) {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Leite", 4.00, 2);
        carrinho.adicionarItem("Carne", 20.00, 1);
        carrinho.adicionarItem("Pão", 3.00, 3);

        carrinho.exibirItens();
        System.out.println("Valor total: R$ " + carrinho.calcularValorTotal());

        System.out.println("--------------------------");

        carrinho.removerItem("Carne");

        carrinho.exibirItens();
        System.out.println("Valor total: R$ " + carrinho.calcularValorTotal());

    }
}
