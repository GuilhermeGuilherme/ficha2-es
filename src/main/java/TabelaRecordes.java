public class TabelaRecordes {
    private String nome;
    private long tempoJogo;

    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempoJogo = 9999999;
    }

    public long getTempoJogo() {
        return tempoJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setRecorde(String nome, long tempo){
        if (tempo < this.tempoJogo){
            this.nome = nome;
            this.tempoJogo = tempo;
            //todo NotifyRecordesActualizados();
        }
    }
}
