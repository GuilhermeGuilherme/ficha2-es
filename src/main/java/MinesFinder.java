import javax.swing.*;

public class MinesFinder extends JFrame {
    private JPanel Principal;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public MinesFinder(String title) {
        super(title);

        setContentPane(Principal); //
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
