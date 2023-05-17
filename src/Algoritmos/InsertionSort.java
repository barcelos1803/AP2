package Algoritmos;

import Objeto.Lista;

public class InsertionSort {

    public static <A extends Comparable<A>> void insertionSort(Lista<A> lista) {
        int n = lista.getTamanho();
        for (int i = 1; i < n; i++) {
            A chave = lista.obterValor(i);
            int j = i - 1;

            while (j >= 0 && lista.obterValor(j).compareTo(chave) > 0) {
                lista.atualizarValor(j + 1, lista.obterValor(j));
                j--;
            }

            lista.atualizarValor(j + 1, chave);
        }
    }
}