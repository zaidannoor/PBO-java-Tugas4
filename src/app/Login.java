/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Lenovo
 */
public class Login extends JFrame {
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Login");
    JLabel judul = new JLabel("Halaman Login");
    JLabel lusername = new JLabel("Username  ");
        JTextField tfusername = new JTextField();
    JLabel lpassword= new JLabel("password  ");
        JTextField tfpassword = new JTextField();
    
    JButton btnLogin = new JButton("Login");
    JButton btnClose = new JButton("Close");
    
    public Login(){
        window.setLayout(null);
        window.setSize(350,200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        setDefaultCloseOperation(3);
        
        // ADD Component
            window.add(judul);
            window.add(lusername);
            window.add(lpassword);
            window.add(tfusername);
            window.add(tfpassword);
            window.add(btnLogin);
            window.add(btnClose);
        
        // Atur Letak
            judul.setBounds(110, 12, 120, 20);
            lusername.setBounds(5, 45, 120, 20);
            lpassword.setBounds(5, 70, 120, 20);

            tfusername.setBounds(85, 45, 125, 20);
            tfpassword.setBounds(85, 70, 125, 20);

            btnLogin.setBounds(65, 110, 80, 20);
            btnClose.setBounds(175, 110, 80, 20);
        
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }
}
