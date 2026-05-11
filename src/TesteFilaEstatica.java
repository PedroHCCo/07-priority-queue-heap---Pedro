import estatica.FilaEstatica;

public class TesteFilaEstatica {

    public static void main(String[] args) {
        deveCriarFilaVaziaComCapacidadeInformada();
        deveEnfileirarElementosNaFila();
        deveDesenfileirarElementosNaFila();
        deveEnfileirarEDesenfileirarElementosNaFila();
        deveDesenfileirarQuandoInicioUltrapassaLimiteDoArray();
    }

    private static void deveCriarFilaVaziaComCapacidadeInformada() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(3);

        try {
            assert fila.capacidade() == 3;
            assert fila.tamanho() == 0;
            assert fila.estaVazia();
            assert !fila.estaCheia();

            System.out.println("-- ✅ Testes de Criação da Fila executado com sucesso --");
        } catch (Exception e) {
            System.out.println("-- ❌ Testes de Criação da Fila falharam --");
        }
    }

    private static void deveEnfileirarElementosNaFila() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);

        try {
            fila.enfileirar(10);
            fila.enfileirar(20);

            assert fila.estaCheia() == true;
            assert fila.tamanho() == 2;

            System.out.println("-- ✅ Testes de Enfileirar Elementos na Fila executado com sucesso --");
        } catch (Exception e) {
            System.out.println("-- ❌ Testes de Enfileirar Elementos na Fila falharam --");
        }
    }

    private static void deveDesenfileirarElementosNaFila() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);

        try {
            fila.enfileirar(10);
            fila.enfileirar(20);

            fila.desenfileirar();
            fila.desenfileirar();

            assert fila.estaVazia() == true;

            System.out.println("-- ✅ Testes de Desenfileirar Elementos na Fila executado com sucesso --");
        } catch (Exception e) {
            System.out.println("-- ❌ Testes de Desenfileirar Elementos na Fila falharam --");
        }
    }

    private static void deveEnfileirarEDesenfileirarElementosNaFila() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(2);

        try {
            fila.enfileirar(10);
            fila.enfileirar(20);

            fila.desenfileirar();

            fila.enfileirar(30);

            assert fila.tamanho() == 2;
            assert fila.frente() == 20;

            System.out.println("-- ✅ Testes de Desenfileirar e Enfileirar na Fila executado com sucesso --");
        } catch (Exception e) {
            System.out.println("-- ❌ Testes de Desenfileirar e Enfileirar na Fila falharam --");
        }
    }

    private static void deveDesenfileirarQuandoInicioUltrapassaLimiteDoArray() {
        FilaEstatica<Integer> fila = new FilaEstatica<>(5);

        try {
            fila.enfileirar(10);
            fila.enfileirar(20);
            fila.enfileirar(30);
            fila.enfileirar(40);
            fila.enfileirar(50);

            fila.desenfileirar();
            fila.desenfileirar();
            fila.desenfileirar();

            fila.enfileirar(60);
            fila.enfileirar(70);

            fila.desenfileirar();
            fila.desenfileirar();

            // Aqui vai estourar o erro!
            fila.desenfileirar();

            assert fila.tamanho() == 2;
            assert fila.frente() == 60;
            assert fila.frente() == 60;

            System.out.println("-- ✅ Testes de DesenfileirarQuandoInicioUltrapassaLimiteDoArray executado com sucesso --");
        } catch (Exception e) {
            System.out.println("-- ❌ Testes de DesenfileirarQuandoInicioUltrapassaLimiteDoArray falharam --");
        }
    }
}
