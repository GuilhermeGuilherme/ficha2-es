import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;

public class TabelaRecordes implements Serializable {

    private String nome;
    private long tempoJogo;

    private transient ArrayList<TabelaRecordesListener> listeners;


    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempoJogo = 9999999;
        listeners = new ArrayList<>();
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
            notifyRecordesActualizados();
        }
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list){
        if (listeners == null) listeners = new ArrayList<>();
        listeners.add(list);
    }

    public void removeTabelaRecordesListener(TabelaRecordesListener list){
        if (listeners != null) listeners.remove(list);
    }

    private void notifyRecordesActualizados() {
        if (listeners != null) {
            for (TabelaRecordesListener list : listeners) {
                list.recordesActualizados(this);
            }
        }
    }


}
