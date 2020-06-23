/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import DAO.*;
import Model.*;
import View.Manager.*;
/**
 *
 * @author Vu Minh Duc
 */
public class MainFrm {
    public static void main(String[] args) {

    /**
     *
     */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStat().setVisible(true);
            }
        });   
    }
}
