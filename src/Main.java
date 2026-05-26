package estatica;

/**
 * Classe principal pra testar o funcionamento do heap com os pacientes do roteiro
 */
public class Main {
    public static void main(String[] args) {
        FilaPrioridadeHeap fila = new FilaPrioridadeHeap();

        // Criando o pessoal do teste
        Paciente[] pacientes = {
            new Paciente("Carlos", 1, 45, false),
            new Paciente("Maria", 5, 5, false),
            new Paciente("João", 3, 20, false),
            new Paciente("Beatriz", 3, 35, true),
            new Paciente("Pedro", 5, 2, false),
            new Paciente("Helena", 2, 45, true)
        };

        System.out.println("--- REGISTRANDO PACIENTES ---");
        for (Paciente p : pacientes) {
            System.out.println("Chegou: " + p.getNome());
            fila.enfileirar(p);
            System.out.print("Estado do Heap: ");
            fila.imprimirEstado();
            System.out.println("-");
        }

        System.out.println("\n--- ATENDIMENTO (ORDEM DE PRIORIDADE) ---");
        int ordem = 1;
        while (!fila.estaVazia()) {
            Paciente atendido = fila.desenfileirar();
            System.out.println(ordem + ". " + atendido.getNome());
            ordem++;
        }
    }
}
