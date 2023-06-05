/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.AmenityModel;
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
public class AmmenityController {
    
    
   
    public static Response insertHotelAmmenity(  int idAmenity, int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insert_AmenityHotel(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setInt(1, idAmenity);
            call.setInt(2, idHotel);

            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

           
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Amenity registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }
    
    public static Response insertRoomAmmenity(  int idAmenity, int idRoom) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insert_AmenityxRoom(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setInt(1, idAmenity);
            call.setInt(2, idRoom);

            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

           
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Amenity registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }
    
    
    public static Response removeAmmenity(  int idAmm, int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call Delete_AmenityHotel(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setInt(1, idAmm);
            call.setInt(2, idHotel);

            call = queryData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

           
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Amenity removida exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }
    
    
    
    public static ArrayList<AmenityModel> getAmenities() {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getAllAmenities()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<AmenityModel> amenities = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            //call.registerOutParameter(1, OracleTypes.CURSOR);

            call = queryData(call);

           if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                
                    String name = rs.getString("name");
                    //int idHotel = rs.getInt("idHotel");
                    int idAmmenity = rs.getInt("idAmenity");
                    AmenityModel amm = new AmenityModel(name, 0, idAmmenity);
                    amenities.add(amm);
                }
            }

            // Se obtiene el código de respuesta del procedimiento (para verificar si hubo algún error en la ejecución).
            // Este código lo puede utilizar para verificar que tipo de error hubo, y así poder generar un mensaje de error
            // claro para el usuario sobre el error que sucedió.
            //int result_code = call.getInt(15);
            // Se cierra la conexión con la base de datos.
            // ES IMPORTANTE QUE SIEMPRE QUE SE ABRA UNA CONEXIÓN LA CIERRE, PUES ESTAS NO SE CIERRAN 
            // AUTOMÁTICAMENTE. 
            call.getConnection().close();
            call.close();

            // Se retorna el objeto respuesta.
            /* Para esta prueba, el código de error 0 significa que no hubo errores.
             if (result_code != 0) {
             return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
             }*/
//            return new Response(Response_code.SUCCESS, "Persona obtenida exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
//            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }

        return amenities;
    }
   
     public static ArrayList<AmenityModel> getAmenitiesByHotel(int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getAmenitiesByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<AmenityModel> amenities = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            
            call.setInt(1, idHotel);
            //call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

           if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                
                    String name = rs.getString("name");
                      
                    int idAmmenity = rs.getInt("idAmenity");
                    AmenityModel amm = new AmenityModel(name, idHotel, idAmmenity);
                    amenities.add(amm);
                }
            }

            // Se obtiene el código de respuesta del procedimiento (para verificar si hubo algún error en la ejecución).
            // Este código lo puede utilizar para verificar que tipo de error hubo, y así poder generar un mensaje de error
            // claro para el usuario sobre el error que sucedió.
            //int result_code = call.getInt(15);
            // Se cierra la conexión con la base de datos.
            // ES IMPORTANTE QUE SIEMPRE QUE SE ABRA UNA CONEXIÓN LA CIERRE, PUES ESTAS NO SE CIERRAN 
            // AUTOMÁTICAMENTE. 
            call.getConnection().close();
            call.close();

            // Se retorna el objeto respuesta.
            /* Para esta prueba, el código de error 0 significa que no hubo errores.
             if (result_code != 0) {
             return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
             }*/
//            return new Response(Response_code.SUCCESS, "Persona obtenida exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
//            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }

        return amenities;
    }
   
     
      public static ArrayList<AmenityModel> getAmenitiesByRoom(int idIDRoom) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getAmenitiesByRoom(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<AmenityModel> amenities = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            
            call.setInt(1, idIDRoom);
           

            call = queryData(call);

           if (call != null) {

                ResultSet rs = (ResultSet) call.getObject(2);
                while (rs.next()) {

                
                    String name = rs.getString("name");
                       //  int idHotel = rs.getInt("idHotel");
                      int idAmmenity = rs.getInt("idAmenity");
                    AmenityModel amm = new AmenityModel(name, 0, idAmmenity);
                    amenities.add(amm);
                }
            }

            // Se obtiene el código de respuesta del procedimiento (para verificar si hubo algún error en la ejecución).
            // Este código lo puede utilizar para verificar que tipo de error hubo, y así poder generar un mensaje de error
            // claro para el usuario sobre el error que sucedió.
            //int result_code = call.getInt(15);
            // Se cierra la conexión con la base de datos.
            // ES IMPORTANTE QUE SIEMPRE QUE SE ABRA UNA CONEXIÓN LA CIERRE, PUES ESTAS NO SE CIERRAN 
            // AUTOMÁTICAMENTE. 
            call.getConnection().close();
            call.close();

            // Se retorna el objeto respuesta.
            /* Para esta prueba, el código de error 0 significa que no hubo errores.
             if (result_code != 0) {
             return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
             }*/
//            return new Response(Response_code.SUCCESS, "Persona obtenida exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
//            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }

        return amenities;
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
