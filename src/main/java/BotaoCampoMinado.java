import javax.swing.*;
import java.awt.*;

public class BotaoCampoMinado extends JButton {
    private int estado;
    private int linha;
    private int coluna;

    public BotaoCampoMinado(int linha, int coluna) {
        this.estado = CampoMinado.TAPADO;

        this.linha = linha;
        this.coluna = coluna;
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        switch (estado) {
            case CampoMinado.VAZIO:
                setText("");
                setBackground(Color.LIGHT_GRAY);
                break;
            case CampoMinado.TAPADO:
                setText("");
                setBackground(null);
                break;
            case CampoMinado.DUVIDA:
                setText("?");
                setBackground(Color.yellow);
                break;
            case CampoMinado.MARCADO:
                setText("!");
                setBackground(Color.red);
                break;
            case CampoMinado.REBENTADO:
                setText("*");
                setBackground(Color.ORANGE);
                break;
                //todo corrigir cor rebentado
            default:
                setText(String.valueOf(estado));
                setBackground(Color.LIGHT_GRAY);
        }
    }


}
