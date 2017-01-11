package abstractfactory;

import javax.swing.JButton;

public class AFactory implements ButtonFactory {

    @Override
    public JButton createButton() {
        return new ButtonA();
    }

    @Override
    public String toString() {
        return "AFactory";
    }

}
