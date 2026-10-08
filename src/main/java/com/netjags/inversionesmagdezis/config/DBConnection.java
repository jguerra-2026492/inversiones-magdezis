/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.netjags.inversionesmagdezis.config;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author informatica
 */
public class DBConnection {
    
    private static Connection connection;
    
    private DBConnection(){
    
    }
        public static Connection getDBConnection() throws SQLException{
        
     if(connection == null || connection.isClosed()){
     
        connection = DriverManager.getConnection(Credentials.URL_DB, Credentials.USER_DB, Credentials.PASS_DB);
     }
        return connection;
    }
    
}
