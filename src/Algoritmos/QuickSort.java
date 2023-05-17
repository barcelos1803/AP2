package Algoritmos;
import Objeto.Lista;

public class QuickSort {

    // Função para ordenar a lista usando o algoritmo QuickSort
    public static <A extends Comparable<A>> void quickSort(Lista<A> lista, int esquerda, int direita) {
        if (esquerda < direita) {
            // Chama a função repartir() para dividir a lista e obter o índice do pivô
            int pivoIndice = repartir(lista, esquerda, direita);
            // Chama recursivamente a função quickSort() para ordenar as duas metades da lista em relação ao pivô
            quickSort(lista, esquerda, pivoIndice - 1);
            quickSort(lista, pivoIndice + 1, direita);
        }
    }

    // Função auxiliar para o QuickSort: particiona a lista e retorna o índice do pivô
    public static <A extends Comparable<A>> int repartir(Lista<A> lista, int esquerda, int direita) {
        A pivo = lista.obterValor(direita);
        int i = esquerda - 1;

        for (int j = esquerda; j <= direita - 1; j++) {
            if (lista.obterValor(j).compareTo(pivo) < 0) {
                i++;
                A temp = lista.obterValor(i);
                lista.atualizarValor(i, lista.obterValor(j));
                lista.atualizarValor(j, temp);
            }
        }

        A temp = lista.obterValor(i + 1);
        lista.atualizarValor(i + 1, lista.obterValor(direita));
        lista.atualizarValor(direita, temp);

        return i + 1;
    }
}
