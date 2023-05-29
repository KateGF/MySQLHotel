/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author guzka
 */
public class ConnectionDB {

  
public  Connection getConnection() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Para el método getConnection del driver debe colocar el url la base de datos a la que se desea conectar,
            // el nombre del esquema que desea utilizar y la contraseña de dicho esquema.
           // return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1524:ort", "katy", "1234");
            // String url = "jdbc:oracle:thin:@localhost:1524:ort";
             String dbURL = "jdbc:oracle:thin:katy/1234@localhost:1524:ort";
           // Class.forName("oracle.jdbc.OracleDriver");
            
            Connection conn = DriverManager.getConnection(dbURL);
            return conn;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    public  Connection getConnection2() {
        
    try{  
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hoteles", "katy", "@Katy123");
          
            return con;
           
        } catch (Exception e) {
            System.out.println(e);
              return null;
        }
    }
    
}
