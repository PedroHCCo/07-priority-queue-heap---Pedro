package estatica;

public class FilaEstatica<T> {
    protected final T[] elementos;
    protected int inicio;
    protected int fim;
    protected int tamanho;

    public FilaEstatica(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        this.elementos = (T[]) new Object[capacidade];
    }

    public void enfileirar(T valor) {
        if (estaCheia()) {
           throw new RuntimeException("Fila está cheia");
        }

        elementos[fim] = valor;
        // fim = (fim + 1) % capacidade();

        fim++;
        if (fim == capacidade()) {
            fim = 0;
        }

        tamanho++;
    }

    // Implementação com complexidade O(1)
    public T desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("A fila está vazia");
        }

        T elementoRemovido = (T) elementos[inicio];
        elementos[inicio] = null;
        inicio++;
        if (inicio == capacidade()) {
            inicio = 0;
        }

        tamanho--;

        return elementoRemovido;
    }


    /*
      - Implementação com complexidade O(n) em vez de O(1)

        Fila com 1 milhão de elementos e fizer 1 milhão de desenfileiramentos:
         - Array circular: 1 milhão × O(1) = 1 milhão de operações
         - Array com deslocamento: 1 milhão × O(n) = 1 trilhão de operações
    */
    public T desenfileirarComDeslocamento() {
        if (estaVazia()) throw new IllegalStateException("Fila vazia");

        T valorRemovido = (T) elementos[0]; // remove sempre do início

        // Desloca todos os elementos uma posição para a esquerda
        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamanho - 1] = null;
        tamanho--;
        return valorRemovido;
    }

    public T frente() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila esta vazia.");
        }

        return (T) elementos[inicio];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int tamanho() {
        return tamanho;
    }

    public int capacidade() {
        return elementos.length;
    }
}
