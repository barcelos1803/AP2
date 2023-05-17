import Objeto.Lista;
import static Algoritmos.InsertionSort.insertionSort;
import static Algoritmos.QuickSort.quickSort;


public class Main {
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();
        lista.inserirInicio(5);
        lista.inserirFim(7);
        lista.inserirElemento(3, 7);
        lista.inserirInicio(8);
        lista.inserirFim(2);
        lista.inserirFim(1);

        // Imprimir a lista antes da ordenação
        System.out.println("Lista antes da ordenação:");
        lista.imprimir();

        // Chamar o algoritmo de ordenação Insertion Sort
        insertionSort(lista);

        // Imprimir a lista após a ordenação
        System.out.println("Lista após a ordenação:");
        lista.imprimir();

        // Chamar o algoritmo de ordenação QuickSort
        quickSort(lista, 0, lista.getTamanho() - 1);

        // Imprimir a lista após a ordenação com QuickSort
        System.out.println("Lista após a ordenação com QuickSort:");
        lista.imprimir();
    }
}