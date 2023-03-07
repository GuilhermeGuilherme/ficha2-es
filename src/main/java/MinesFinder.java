import javax.swing.*;
import java.awt.event.ActionEvent;

public class MinesFinder extends JFrame {
    private JPanel Principal;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton btnSair;

    public MinesFinder(String title) {
        super(title);

        setContentPane(Principal); //
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        pack();

        btnSair.addActionListener(this::btnSairActionPerformed);
    }

    private void btnSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
