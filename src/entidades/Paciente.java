package estatica;
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

    @Override
    public int compareTo(Paciente outro) {
        // 1. Nível de urgência
        if (this.nivelUrgencia != outro.nivelUrgencia) {
            return Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
        }
        // 2. Tempo de espera
        if (this.tempoEsperaMinutos != outro.tempoEsperaMinutos) {
            return Integer.compare(this.tempoEsperaMinutos, outro.tempoEsperaMinutos);
        }
        // 3. Grupo vulnerável (true é "maior" que false)
        return Boolean.compare(this.grupoVulneravel, outro.grupoVulneravel);
    }

    @Override
    public String toString() {
        return nome + "(U:" + nivelUrgencia + ", T:" + tempoEsperaMinutos + "m, V:" + grupoVulneravel + ")";
    }
}
