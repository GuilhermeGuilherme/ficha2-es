import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinesFinder extends JFrame {
    private JPanel Principal;
    private JButton btnJogoFacil;
    private JButton btnJogoDificil;
    private JButton btnJogoMedio;
    private JButton btnSair;
    private JLabel lblNomeFacil;
    private JLabel lblTempoFacil;
    private JLabel lblNomeDificil;
    private JLabel lblTempoMedio;
    private JLabel lblTempoDificil;
    private JLabel lblNomeMedio;

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
        lerRecordesDoDisco();

        lblNomeFacil.setText(recordesFacil.getNome());
        lblTempoFacil.setText(Long.toString(recordesFacil.getTempoJogo()/1000));
        lblNomeMedio.setText(recordesMedio.getNome());
        lblTempoMedio.setText(Long.toString(recordesMedio.getTempoJogo()/1000));
        lblNomeDificil.setText(recordesDificil.getNome());
        lblTempoDificil.setText(Long.toString(recordesDificil.getTempoJogo()/1000));

        recordesFacil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesFacilActualizado(recordes);
            }
        });
        recordesMedio.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesMedioActualizado(recordes);
            }
        });
        recordesDificil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesDificilActualizado(recordes);
            }
        });
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

    private void recordesFacilActualizado(TabelaRecordes recordes) {
        lblNomeFacil.setText(recordes.getNome());
        lblTempoFacil.setText(Long.toString(recordes.getTempoJogo()/1000));
    }
    private void recordesMedioActualizado(TabelaRecordes recordes) {
        lblNomeMedio.setText(recordes.getNome());
        lblTempoMedio.setText(Long.toString(recordes.getTempoJogo()/1000));
    }
    private void recordesDificilActualizado(TabelaRecordes recordes) {
        lblNomeDificil.setText(recordes.getNome());
        lblTempoMedio.setText(Long.toString(recordes.getTempoJogo()/1000));
    }

    private void guardarRecordesDisco() {
        ObjectOutputStream oos = null;
        try {
            File f =new
                    File(System.getProperty("user.home")+File.separator+"minesfinder.recordes");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(recordesFacil);
            oos.writeObject(recordesMedio);
            oos.writeObject(recordesDificil);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    private void lerRecordesDoDisco() {
        ObjectInputStream ois = null;
        File f = new
                File(System.getProperty("user.home")+File.separator+"minesfinder.recordes");
        if (f.canRead()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                recordesFacil=(TabelaRecordes) ois.readObject();
                recordesMedio=(TabelaRecordes) ois.readObject();
                recordesDificil=(TabelaRecordes) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,
                        null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
        }
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
