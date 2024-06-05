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
        for(Item i : itemList) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                itemsParaRemover.add(i);
            }
        }
        itemList.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal() {
        double soma = 0;
        for(Item i : itemList) {
            soma += i.getPreco() * i.getQuantidade();
        }
        return soma;
    }

    public void exibirItens() {
        System.out.println(itemList);
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
