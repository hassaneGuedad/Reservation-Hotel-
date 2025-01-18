/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_jdbc_swing;

import Forms.Authentification;
import javax.swing.UIManager;

/**
 *
 * @author PC
 */
public class Project_Jdbc_Swing {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.windowLookAndFell");
        }catch(Exception e){
            
        }
        Authentification au =new Authentification();
        au.setVisible(true);
}
}