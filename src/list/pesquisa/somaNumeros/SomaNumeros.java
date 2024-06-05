package list.pesquisa.somaNumeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> listNumeros;

    public SomaNumeros() {
        this.listNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listNumeros.add(numero);
    }

    public int calcularSoma() {
        if(!listNumeros.isEmpty()) {
            int soma = 0;
            for(Integer n : listNumeros) {
                soma += n;
            }
            return soma;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMaiorNumero() {
        int maiorNumero = Integer.MIN_VALUE;
        if(!listNumeros.isEmpty()) {
            for(Integer n : listNumeros) {
                if(n >= maiorNumero) {
                    maiorNumero = n;
                }
            }
            return maiorNumero;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMenorNumero() {
        int menorNumero = Integer.MAX_VALUE;
        if(!listNumeros.isEmpty()) {
            for(Integer n : listNumeros) {
                if(n <= menorNumero) {
                    menorNumero = n;
                }
            }
            return menorNumero;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!listNumeros.isEmpty()) {
            System.out.println(listNumeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    // Testes
    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        System.out.println("Números adicionados: ");
        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
