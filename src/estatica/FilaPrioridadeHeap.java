package estatica;

import java.util.ArrayList;

/**
 * Implementacao de uma fila de prioridade utilizando a estrutura de Heap Binario.
 * Mantem os pacientes mais urgentes sempre no topo da estrutura.
 */
public class FilaPrioridadeHeap {
    private ArrayList<Paciente> heap;

    public FilaPrioridadeHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Coloca um novo paciente na fila. 
     * Ele entra no final e depois a gente usa o sobeHeap pra colocar ele na posicao certa.
     */
    public void enfileirar(Paciente paciente) {
        heap.add(paciente);
        sobeHeap(heap.size() - 1);
    }

    /**
     * Tira o paciente que tem a maior prioridade (o que ta na posicao 0).
     * Depois pega o ultimo da fila, joga pro topo e chama o desceHeap pra organizar.
     */
    public Paciente desenfileirar() {
        if (heap.isEmpty()) {
            return null;
        }
        
        Paciente removido = heap.get(0);
        Paciente ultimo = heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            desceHeap(0);
        }
        return removido;
    }

    /**
     * Metodo auxiliar pra fazer o paciente "subir" no heap se a prioridade dele for maior que a do pai.
     */
    private void sobeHeap(int indice) {
        int pai = (indice - 1) / 2;
        
        while (indice > 0 && heap.get(indice).compareTo(heap.get(pai)) > 0) {
            trocar(indice, pai);
            indice = pai;
            pai = (indice - 1) / 2;
        }
    }

    /**
     * Metodo auxiliar pra fazer um paciente "descer" no heap ate achar o lugar dele,
     * comparando com os filhos da esquerda e da direita.
     */
    private void desceHeap(int indice) {
        int tamanho = heap.size();
        
        while (true) {
            int maior = indice;
            int esquerda = 2 * indice + 1;
            int direita = 2 * indice + 2;

            if (esquerda < tamanho && heap.get(esquerda).compareTo(heap.get(maior)) > 0) {
                maior = esquerda;
            }
            if (direita < tamanho && heap.get(direita).compareTo(heap.get(maior)) > 0) {
                maior = direita;
            }
            if (maior != indice) {
                trocar(indice, maior);
                indice = maior;
            } else {
                break;
            }
        }
    }

    private void trocar(int i, int j) {
        Paciente temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void imprimirEstado() {
        System.out.println(heap.toString());
    }

    public boolean estaVazia() {
        return heap.isEmpty();
    }
}
