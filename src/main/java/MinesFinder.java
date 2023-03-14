import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.event.ActionEvent;

public class MinesFinder extends JFrame {
    private JPanel Principal;
    private JButton btnJogoFacil;
    private JButton btnJogoDificil;
    private JButton btnJogoMedio;
    private JButton btnSair;

    private TabelaRecordes recordesFacil;
    private TabelaRecordes recordesMedio;
    private TabelaRecordes recordesDificil;

    public MinesFinder(String title) {
        super(title);

        setContentPane(Principal); //
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        pack();

        btnSair.addActionListener(this::btnSairActionPerformed);
        btnJogoFacil.addActionListener(this::btnJogoFacilActionPerformed);
        btnJogoMedio.addActionListener(this::btnJogoMedioActionPerformed);
        btnJogoDificil.addActionListener(this::btnJogoDificilActionPerformed);

        //codigo de teste de teste
        CampoMinado campo = new CampoMinado(10,10,10);
        System.out.println("linhas "+campo.getNrLinhas());

        this.recordesFacil = new TabelaRecordes();
        this.recordesDificil = new TabelaRecordes();
        this.recordesMedio = new TabelaRecordes();

    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnJogoFacilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(9,9,10), recordesFacil);
        janela.setVisible(true);
    }
    private void btnJogoMedioActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,16,40), recordesMedio);
        janela.setVisible(true);
    }
    private void btnJogoDificilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,30,90), recordesDificil);
        janela.setVisible(true);
    }


    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
