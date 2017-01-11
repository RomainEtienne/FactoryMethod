package abstractfactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    public Window() {

        AFactory aFactory = new AFactory();
        JButton button = aFactory.createButton();

        ArrayList<ButtonFactory> listFactory = new ArrayList<ButtonFactory>();
        listFactory.add(new AFactory());
        listFactory.add(new BFactory());
        JComboBox combo = new JComboBox(listFactory.toArray());

        JPanel pan = new JPanel();
        pan.add(combo);
        pan.add(button);

        combo.addActionListener((ActionEvent ae) -> {
            ButtonFactory buttonFactory = (ButtonFactory) combo.getSelectedItem();
            JButton button1 = buttonFactory.createButton();
            pan.remove(1);
            pan.add(button1);
            pan.repaint();
            pan.revalidate();
        });

        this.setContentPane(pan);
        this.setTitle("Abstract Factory");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
