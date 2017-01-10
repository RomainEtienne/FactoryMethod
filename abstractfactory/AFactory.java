/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import javax.swing.JButton;

/**
 *
 * @author Romain
 */
public class AFactory implements ButtonFactory{

    @Override
    public JButton createButton() {
        return new BoutonA();
    }
    
}
