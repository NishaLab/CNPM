/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Manager;

import View.Manager.ManagerFrm;
import View.Manager.*;
import View.User.ClientStatFrm;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author LEGION
 */
public class ManagerFrameController {

    private ManagerFrm frame;

    public ManagerFrameController(ManagerFrm frame) {
        this.frame = frame;
    }

    public void init() {
        setViewCarStatAction();
        setViewClientStatAction();
    }

    public void setViewCarStatAction() {
        JLabel carStat = this.frame.getCarStatText();
        carStat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChooseStatType cst = new ChooseStatType(frame.getStaff());
                frame.dispose();
                cst.setVisible(true);
                cst.setLocationRelativeTo(null);
            }
        });
    }

    public void setViewClientStatAction() {
        JLabel clientStat = this.frame.getClientStatText();
        clientStat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ClientStatFrm csf = new ClientStatFrm();
                frame.dispose();
                csf.setVisible(true);
            }
        });
    }
}
