/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Rental;

import View.Rental.Component.CartComponent;
import View.Rental.SearchCarViewFrm;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author LEGION
 */
public class CartComponentController {

    private CartComponent panel;

    public CartComponentController(CartComponent panel) {
        this.panel = panel;
    }

    public void init() {
        setExitAction();
    }

    public void setExitAction() {
        JLabel exit = panel.getExitLabel();
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchCarViewFrm frame = panel.getFrame();
                if (JOptionPane.showConfirmDialog(null, "Do you delete " + panel.getCar().getName(),
                        "Pick", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION) == JOptionPane.YES_OPTION) {
                    frame.getCartPanel().remove(panel);
                    frame.getCartPanel().revalidate();
                    frame.getCartPanel().repaint();

                }
            }

        }
        );
    }
}
