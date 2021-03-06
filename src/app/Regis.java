/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.security.NoSuchAlgorithmException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Regis extends JFrame  {
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Registrasi");
    JLabel judul = new JLabel("Halaman Registrasi");
    JLabel lusername = new JLabel("Username  ");
        JTextField tfusername = new JTextField();
    JLabel lpassword= new JLabel("password  ");
        JTextField tfpassword = new JTextField();
    
    JButton btnRegis = new JButton("Registrasi");
    JButton btnClose = new JButton("Close");
    public Regis() throws NoSuchAlgorithmException{
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
        window.add(btnRegis);
        window.add(btnClose);
        // Atur Letak
        judul.setBounds(100, 12, 120, 20);
        lusername.setBounds(5, 45, 120, 20);
        lpassword.setBounds(5, 70, 120, 20);

        tfusername.setBounds(85, 45, 125, 20);
        tfpassword.setBounds(85, 70, 125, 20);

        btnRegis.setBounds(60, 110, 100, 20);
        btnClose.setBounds(180, 110, 80, 20);
        
        btnRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                Users user = new Users(); // instansiasi objek user
                String data[][] = new String[1][3]; // deklarasi variabel data bertipe String
                data = user.getUserByUsername(getUsername()); // mengambil data dari database
                if(getUsername().equals("") || getPassword().equals("")){
                    JOptionPane.showMessageDialog(null,"Username atau password tidak boleh kosong");
                }
                else{
                    if(data[0][0] == null){  
                        // jika username tidak ada di database maka menjalankan method insertusertodatabase
                          try {
                            user.insertUserToDatabase(getUsername(), getPassword());
                            Login login = new Login(); // memanggil view halaman login
                            window.setVisible(false); // membuat view regis menjadi tak terlihat
                            } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(Regis.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                    else{ // jika ada maka tampilkan pesan kesalahan
                        JOptionPane.showMessageDialog(null,"Registrasi gagal !!");
                        JOptionPane.showMessageDialog(null,"username telah digunakan orang lain, silahkan coba username lain !!");
                    }
                }
                              
            }
        });
        
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0); // close program
            }
        });
    }
    
    
    public String getUsername(){
        return tfusername.getText();
    }
    public String getPassword(){
        return tfpassword.getText();
    }
}
