/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dhanuka Perera
 */
public class DBConnection 
{
    public static Connection connect()
     {
         Connection dbConnection = null;
        
         // Conecting to datebase.
         try 
         {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pavana-hms","root","");
            
           
         } 
         catch (ClassNotFoundException | SQLException e) 
         {
            // datebase connection fails.
            System.out.println(e); 
         }
         
         return dbConnection;
        
     }
}
