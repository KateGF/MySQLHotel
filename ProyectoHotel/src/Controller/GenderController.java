/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GenderModel;
import Model.Location.Location;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guzka
 */
public class GenderController {
    
    
    
    public static ArrayList<GenderModel> getGenders() {
        ArrayList<GenderModel> genders = new ArrayList<>();
        String statement = "{call getGenders()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            
            if(DBconnection != null){
                 // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("type");
                    int idX = rs.getInt("idGender");
                }
            }

            call.getConnection().close();
            call.close();
            }else{
                
            }
           
        } catch (SQLException e) {
            System.out.println(e);

        }
        return genders;
    }
    
    
    private static CallableStatement insertData(CallableStatement call) {
        try {
            call.executeQuery();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    private static CallableStatement queryData(CallableStatement call) {
        try {
            call.execute();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
