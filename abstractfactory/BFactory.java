package abstractfactory;

import javax.swing.JButton;

public class BFactory implements ButtonFactory {

    @Override
    public JButton createButton() {
        return new ButtonB();
    }

    @Override
    public String toString() {
        return "BFactory";
    }
}
