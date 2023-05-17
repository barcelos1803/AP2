package Objeto;


public class Lista<A> {

     private static class Elemento<A> {
         A valor; /* campo que guarda o valor do elemento*/
         Elemento<A> anterior; /* campo que guarda a referencia do elemento anterior*/
         Elemento<A> proximo; /* campo que guarda a referencia do proximo elemento*/

         public Elemento(A valor) {  /* construtor da classe Elemento*/
             this.valor = valor;
             this.anterior = null;
             this.proximo = null;
         }
     }
    protected Elemento<A> primeiro;
    protected Elemento<A> ultimo;
    private int tamanho;

    /*definindo os atributos como private eu garanto que
     eles não serão acessados diretamente por outras classes que utilizam a lista duplamente encadeada
     evitando que a estrutura da lista seja modificada, obrigado professor Cassio pelas aulas de encapsulamento,
     isso garante que o código ficara mais facil de manter e testar*/

    public Lista() { /* construtor que inicializa os valores da lista*/
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void inserirInicio(A valor) { /* metodo para inserir o inicio da lista*/
        Elemento<A> novoElemento = new Elemento<>(valor);

        if (this.tamanho == 0) {
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            novoElemento.proximo = this.primeiro;
            this.primeiro.anterior = novoElemento;
            this.primeiro = novoElemento;
        }

        this.tamanho++;
    }

    public void inserirFim(A valor) { /* metodo para inserir o fim da lista, me sinto um maluco entendendo isso*/
        Elemento<A> novoElemento = new Elemento<>(valor);

        if (this.tamanho == 0) {
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            novoElemento.anterior = this.ultimo;
            this.ultimo.proximo = novoElemento;
            this.ultimo = novoElemento;
        }

        this.tamanho++;
    }

    /* nos dois metodos eu criei um novo elemento e atualizei as referencias do primeiro e do ultimo elemento,
    * pra manter o encadeamento da lista*/

    public A removerInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia.");
        }

        A valor = this.primeiro.valor;

        if (this.tamanho == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            this.primeiro = this.primeiro.proximo;
            this.primeiro.anterior = null;
        }

        this.tamanho--;

        return valor;
    }

    public A removerFim() {
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia.");
        }

        A valor = this.ultimo.valor;

        if (this.tamanho == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {
            this.ultimo = this.ultimo.anterior;
            this.ultimo.proximo = null;
        }

        this.tamanho--;

        return valor;
    }

    /* mesma coisa aqui, criei os metodos pra remover o inicio e o fim da lista e atualizei as referencias em seguida,
    * criei uma exception simples pra quando a lista estiver vazia*/

    public A obterValor(int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("posição não encontrada");
        }

        Elemento<A> ElementoAtual = this.primeiro; /* aqui eu seto a variavel pro primeiro elemento da lista*/

        for (int i = 0; i < posicao; i++) {
            ElementoAtual = ElementoAtual.proximo; /* pra cada loopada a referencia do proximo é armazenada na variavel
            ele vai loopar ate chegar na posição passada por parametro e  vai retornar o valor*/
        }

        return ElementoAtual.valor;
    }

    public int getTamanho() { /* aqui retorna apenas o tamanho da lista, bem tranquilo*/
        return this.tamanho;
    }

    public Elemento<A> getPrimeiro() {
        return this.primeiro;
    }
    public Elemento<A> obterElemento(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }

        Elemento<A> elementoAtual = primeiro;
        for (int i = 0; i < indice; i++) {
            elementoAtual = elementoAtual.proximo;
        }

        return elementoAtual;
    }
    public void atualizarValor(int indice, A valor) {
        Elemento<A> elementoAtual = obterElemento(indice);

        if (elementoAtual != null) {
            elementoAtual.valor = valor;
        }
    }

    public void imprimir() { /* primeiro verifica se a lista ta vazia, se nao estiver ele seta a variavel pro primeiro elemento
    depois percorre e imprime todos os elementos da lista separado por um espaço */
        if (this.tamanho == 0) {
            System.out.println("Objeto.Lista vazia!");
        } else {
            Elemento<A> posicaoAtual = this.primeiro;

            while (posicaoAtual != null) {
                System.out.print(posicaoAtual.valor + " ");
                posicaoAtual = posicaoAtual.proximo;
            }
            System.out.println();
        }
    }

    public void imprimirReverso() { /* mesma coisa do imprimir normal, mas seta a variavel pro ultimo elemento e percorre o laço
     até o primeiro, bem simples.*/
        if (this.tamanho == 0) {
            System.out.println("Objeto.Lista vazia!");
        } else {
            Elemento<A> posicaoAtual = this.ultimo;

            while (posicaoAtual != null) {
                System.out.print(posicaoAtual.valor + " ");
                posicaoAtual = posicaoAtual.anterior;
            }
            System.out.println();
        }
    }

    public void inserirElemento(A valor, A elemento) {
        Elemento<A> novoElemento = new Elemento<>(valor);

        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia. Não é possível inserir");
        }

        Elemento<A> elementoAtual = this.primeiro;
        while (elementoAtual != null && !elementoAtual.valor.equals(elemento)) {
            elementoAtual = elementoAtual.proximo;
        }

        if (elementoAtual == null) {
            throw new IllegalArgumentException("O elemento não está presente na lista.");
        }

        novoElemento.proximo = elementoAtual.proximo;
        if (elementoAtual.proximo != null) {
            elementoAtual.proximo.anterior = novoElemento;
        }
        elementoAtual.proximo = novoElemento;
        novoElemento.anterior = elementoAtual;

        if (elementoAtual == this.ultimo) {
            this.ultimo = novoElemento;
        }

        this.tamanho++;
    }
}
