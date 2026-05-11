import java.util.PriorityQueue;
import java.util.Queue;

import entidades.Pessoa;
import estatica.FilaComPrioridade;

public class Main {
    public static void main(String args[]){
        System.out.println("--- Fila de Inteiros ---");

        FilaComPrioridade<Integer> fila = new FilaComPrioridade<>(10);

        fila.enfileirar(1);
        fila.enfileirar(3);
        fila.enfileirar(2);

        System.out.println(fila);

        System.out.println("\n--- Fila de Pessoas ---");

        FilaComPrioridade<Pessoa> filaPessoas = new FilaComPrioridade<>(10);

        filaPessoas.enfileirar(new Pessoa("Adão", 1));
        filaPessoas.enfileirar(new Pessoa("Carlos", 3));
        filaPessoas.enfileirar(new Pessoa("Bruno", 2));

        while (!filaPessoas.estaVazia()) {
            System.out.println(filaPessoas.desenfileirar());
        }

        System.out.println("\n--- Fila de Pessoas (PriorityQueue) ---");

        Queue<Pessoa> filaPessoasJava = new PriorityQueue<>(10);

        filaPessoasJava.add(new Pessoa("Adão", 1));
        filaPessoasJava.add(new Pessoa("Carlos", 3));
        filaPessoasJava.add(new Pessoa("Bruno", 2));

        while (!filaPessoasJava.isEmpty()) {
            System.out.println(filaPessoasJava.poll());
        }
    }
}