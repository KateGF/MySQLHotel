/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.Response;
import Model.Review;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guzka
 */
public class ReviewController {

   
    public static Response insertReview(int star,int reserv) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insert_review(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            // Se insertan los parámetros en la llamada. Note que los símbolos de pregunta
            // están indexados (inician a partir de 1, no de 0). 
            // Tome en cuenta que los tipos de datos que inserte aquí, deben coincidir 
            // con los tipos de datos que recibe el procedimiento de la base de datos.

            call.setInt(1, star);
            call.setInt(2, reserv);

            // Los parámetros de salida son parametros que se pueden consultar en el objeto llamada
            // despues de ejecutar la llamada. Son útiles para retornar códigos de error o consultas.
            // call.registerOutParameter(15, java.sql.Types.NUMERIC);
            // Se ejecuta la llamada.
            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
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
            return new Response(Response_code.SUCCESS, "Review registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }
   
    
    
    public static ArrayList<Review> getReviews(int idHotel) {
        String statement = "{call getReviewsHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<Review> reviews = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            //call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {

                    int s_star = rs.getInt("star");
                    int s_idReservation = rs.getInt("idReservation");
                    String s_FirstName = rs.getString("firstName");
                    String s_LastName = rs.getString("LastName");

                    Review revi = new Review(s_star, s_idReservation,s_FirstName, s_LastName);
                    reviews.add(revi);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reviews;
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
