import javax.swing.*;
import java.awt.event.ActionEvent;

public class MinesFinder extends JFrame {
    private JPanel Principal;
    private JButton btnJogoFacil;
    private JButton btnJogoDificil;
    private JButton btnJogoMedio;
    private JButton btnSair;

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
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnJogoFacilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo();
        janela.setVisible(true);
    }
    private void btnJogoMedioActionPerformed(ActionEvent e) {
        // TODO
    }
    private void btnJogoDificilActionPerformed(ActionEvent e) {
        // TODO
    }


    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
