/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.ResultSet;
import javax.swing.*;
import java.sql.SQLException;



/**
 *
 * @author Lenovo
 */
public class Users {
    Connector connector = new Connector();
    
    
    
    public int getUserByUsername(String username){
        String data[][] = new String[2][3];
        int jmlData = 0;
        try{
            String query = "SELECT * FROM users WHERE username='"+username+"'";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("username"); 
                data[jmlData][2] = resultSet.getString("password");
                jmlData++; 
            }
            connector.statement.close();
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            System.out.println(jmlData);
            return jmlData;
        }
    }
    
    public int insertUserToDatabase(String username, String password){
        try {
            String query = "INSERT INTO users (username,password) "
                    + "VALUES ('"+username+"','"+password+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            //System.out.println("Insert Berhasil");
            JOptionPane.showMessageDialog(null,"Registrasi Berhasil !!");
            return 1;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    
}
