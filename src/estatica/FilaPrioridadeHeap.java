package estatica;

import java.util.ArrayList;

public class FilaPrioridadeHeap {
    private ArrayList<Paciente> heap;

    public FilaPrioridadeHeap() {
        this.heap = new ArrayList<>();
    }

    public void enfileirar(Paciente paciente) {
        heap.add(paciente);
        sobeHeap(heap.size() - 1);
    }

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

    private void sobeHeap(int indice) {
        int pai = (indice - 1) / 2;
        
        while (indice > 0 && heap.get(indice).compareTo(heap.get(pai)) > 0) {
            trocar(indice, pai);
            indice = pai;
            pai = (indice - 1) / 2;
        }
    }

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
