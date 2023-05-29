/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
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
public class LocationsController {

    
    public static ArrayList<Location> getCountries() {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getCountries()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
           
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idCountry");
                    Location location = new Location();
                    location.setName(name);
                    location.setID(idX);
                    locations.add(location);
                }
            }
            
            call.getConnection().close();
            call.close();

           
        } catch (SQLException e) {
            System.out.println(e);
        
        }
        return locations;
    }
    
    
    /**
     * Recibe una llamada parametrizada y la manda a ejecutar a la base de
     * datos.
     *
     * @param call
     * @return retorna el objeto de llamada.
     */
    private static CallableStatement insertData(CallableStatement call) {
        try {
            call.executeQuery();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Recibe una consulta parametrizada y la manda a ejecutar a la base de
     * datos.
     *
     * @param call
     * @return retorna el objeto de llamada.
     */
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
