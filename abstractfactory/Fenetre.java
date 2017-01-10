/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.application.ConditionalFeature.SWT;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Romain
 */
public class Fenetre extends JFrame {

    public Fenetre() {

        AFactory aFactory = new AFactory();
        JButton bouton = aFactory.createButton();

        String[] theme = {"A", "B"};
        JComboBox combo = new JComboBox(theme);

        JPanel pan = new JPanel();
        pan.add(combo);
        pan.add(bouton);

        
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox cb = (JComboBox) ae.getSource();
                String theme = (String) cb.getSelectedItem();
                JButton retour;
                if (theme.equals("A")) {
                    AFactory aFactory = new AFactory();
                    JButton boutonA = aFactory.createButton();

                    retour = boutonA;
                } else {
                    BFactory bFactory = new BFactory();
                    JButton boutonB = bFactory.createButton();

                    retour = boutonB;
                }
                pan.remove(1);
                pan.add(retour);
                pan.repaint();
                pan.revalidate();
            }
        });

        this.setContentPane(pan);
        this.setTitle("Abstract Factory");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Fenetre fen = new Fenetre();
    }
}
