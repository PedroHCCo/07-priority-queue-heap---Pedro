package estatica;

/**
 * Representa um paciente que chegou no pronto-socorro.
 * A classe implementa Comparable pra gente conseguir definir quem tem
 * mais prioridade na fila com base nas regras do hospital.
 */
public class Paciente implements Comparable<Paciente> {
    private String nome;
    private int nivelUrgencia;
    private int tempoEsperaMinutos;
    private boolean grupoVulneravel;

    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Compara esse paciente com outro pra saber quem deve ser atendido antes.
     * O desempate segue a ordem: nivel de urgencia, depois o tempo de espera,
     * e por ultimo se e do grupo vulneravel.
     */
    @Override
    public int compareTo(Paciente outro) {
        if (this.nivelUrgencia != outro.nivelUrgencia) {
            return Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
        }
        if (this.tempoEsperaMinutos != outro.tempoEsperaMinutos) {
            return Integer.compare(this.tempoEsperaMinutos, outro.tempoEsperaMinutos);
        }
        return Boolean.compare(this.grupoVulneravel, outro.grupoVulneravel);
    }

    @Override
    public String toString() {
        return nome + "(U:" + nivelUrgencia + ", T:" + tempoEsperaMinutos + "m, V:" + grupoVulneravel + ")";
    }
}
