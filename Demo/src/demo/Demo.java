/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;


/**
 *
 * @author VRUSHABH
 */
public class Demo extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Demo m = new Demo();
        m.setSize(420,420);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //addComponentsToPane(m.getContentPane());
      //  m.setResizable(false);
        m.prepareGUI(m.getContentPane());
        
    }
    
    public void prepareGUI(Container pane)
    {
       // Container pane = null;
        pane.setLayout(new GridBagLayout());
       GridBagConstraints c= new  GridBagConstraints();
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1.0;
        c.weighty=1.0;
        JLabel uname= new JLabel("User Name");
        pane.add(uname,c);
        JTextField un= new  JTextField();
        c.gridx=1;
        pane.add(un,c);
        JLabel pass= new JLabel("Password");
        c.gridx=0;//columns
        c.gridy=1;//rows
        pane.add(pass,c);
        JPasswordField password= new JPasswordField();
        c.gridx=1;//columns
        c.gridy=1;//rows
        pane.add(password,c);
        JButton ok= new JButton("Login");
        c.gridx=0;
        c.gridy=2;
        pane.add(ok,c);
        JButton clr= new JButton("Reset");
        c.gridx=1;
        c.gridy=2;
        pane.add(clr,c);
    }
}
