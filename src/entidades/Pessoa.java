package entidades;

public class Pessoa implements Comparable<Pessoa> {
    String nome;
    Integer prioridade;

    public Pessoa(String nome, Integer prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(Pessoa p) {
        return Integer.compare(prioridade, p.prioridade);
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", prioridade=" + prioridade + "]";
    }
}
