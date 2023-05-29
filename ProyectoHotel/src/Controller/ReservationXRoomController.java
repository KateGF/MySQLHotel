/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.Response;
import Model.UserModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author guzka
 */
public class ReservationXRoomController {

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

    /**
     * Recibe una persona y la la manda a insertar a la base de datos.
     *
     * @param user (Objeto de la clase User)
     * @return retorna una respuesta de tipo Response con código y mensaje.
     */
    public static Response insertReservationxRoom(UserModel user) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call Insert_ReservationXRoom(?,?,?,?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            // Se insertan los parámetros en la llamada. Note que los símbolos de pregunta
            // están indexados (inician a partir de 1, no de 0). 
            // Tome en cuenta que los tipos de datos que inserte aquí, deben coincidir 
            // con los tipos de datos que recibe el procedimiento de la base de datos.



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
            return new Response(Response_code.SUCCESS, "Persona registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }

    /**
     * Recibe un username y la la manda a buscar a la base de datos.
     *
     * @param username (String del username del usuario)
     * @return retorna una respuesta de tipo User
     */
    public static UserModel getUser(String username) {

        String statement = "{call getUsersCurs(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        UserModel userReturn = null;
        try {

            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, username);
            call.registerOutParameter(2, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getObject(2);
                while (rs.next()) {
                    
                    int idUser = rs.getInt("idUser");
                    String firstname = rs.getString("firstname");
                    String s_username = rs.getString("username");
                    String password = rs.getString("password");
                    int idUserType = rs.getInt("idUserType");
                    userReturn = new UserModel(idUser,firstname, s_username, password,idUserType);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
            // new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
        //new Response(Response_code.SUCCESS, "Persona obtenida exitosamente.");
        return userReturn;
    }

    public static boolean Login(String Susername, String password) {

        UserModel user = getUser(Susername);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }

    }

}
