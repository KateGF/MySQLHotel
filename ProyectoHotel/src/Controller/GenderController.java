/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Constants.Response_code;
import Model.GenderModel;
import Model.HotelModel;
import Model.Location.Location;
import Model.Response;
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
                   GenderModel genderModel = new GenderModel(name);
                    genders.add(genderModel); 
                    
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
    
    // no sirve porque debe ser en cascada
     public static Response deleteGender(int gender) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call DELETE_GENDER(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setInt(1, gender);
          

            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

           
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Gender deleted succesfully.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "There was an error, try again.");
        }
    }
    
    
   public static Response insertGender(  String gender) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insertGender(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setString(1, gender);
          

            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

           
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Gender registered succesfully.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
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
