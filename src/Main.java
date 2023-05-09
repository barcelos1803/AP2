import Objeto.Lista;
public class Main {
    public static void main(String[] args){
        Lista<Integer> lista = new Lista<>();
        lista.inserirInicio(5);
        lista.inserirInicio(8);
        lista.inserirInicio(3);
        lista.inserirInicio(2);
        lista.inserirFim(7);
        lista.removerInicio();
        lista.obterValor(2);
        lista.removerFim();
        lista.imprimir();
        lista.imprimir();
        lista.imprimirReverso();
    }
}