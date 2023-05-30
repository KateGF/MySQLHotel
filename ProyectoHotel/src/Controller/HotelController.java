/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;

import Model.HotelModel;
import Model.Response;
import Model.UserModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author guzka
 */
public class HotelController {

    public static Response insertHotel(HotelModel hotel, UserModel user) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insertHotel(?,?,?,?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            // Se insertan los parámetros en la llamada. Note que los símbolos de pregunta
            // están indexados (inician a partir de 1, no de 0). 
            // Tome en cuenta que los tipos de datos que inserte aquí, deben coincidir 
            // con los tipos de datos que recibe el procedimiento de la base de datos.

            call.setString(1, hotel.getName());
            call.setDate(2, new java.sql.Date(hotel.getRegisterDate().getTime()));
            call.setInt(3, hotel.getIdDistrict());
            call.setInt(4, hotel.getIdClassification());
            call.setInt(5, hotel.getIdDiscount());
            call.setString(6, user.getUsername());
            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

            call.getConnection().close();
            call.close();

            return new Response(Response_code.SUCCESS, "Hotel registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }

    public static ArrayList<HotelModel> getHotelsByDistrict(int idDistrict) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<HotelModel> hoteles = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call.setInt(1, idDistrict);

            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                    int idHotel = rs.getInt("idHotel");
                    String name = rs.getString("name");
                    Date registerdate = rs.getDate("RegisterDate");
                    int idDisc = rs.getInt("idDiscount");
                    int classi = rs.getInt("idClasification");
                    HotelModel hotelModel = new HotelModel(idHotel, name, registerdate, idDisc, classi, idDisc);
                    hoteles.add(hotelModel);
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

        return hoteles;
    }

    public static ArrayList<HotelModel> getHotelsByID(int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getHotelInfo(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<HotelModel> hoteles = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call.setInt(1, idHotel);

            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                    String name = rs.getString("name");
                    int idDisc = rs.getInt("Discount");
                    String districtH = rs.getString("District");
                    Date dateReg = rs.getDate("dateReg");
                    String cantonH = rs.getString("Canton");
                    String stateH = rs.getString("State");
                    String countryH = rs.getString("Country");
                    String classi = rs.getString("classi");
                    //String clasification = rs.getString("clasification");
                    HotelModel hotelModel = new HotelModel(idHotel, name, dateReg, idDisc, classi, districtH);
                    hoteles.add(hotelModel);
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

        return hoteles;
    }

    public static ArrayList<HotelModel> getHotels() {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call getHotels()}";
        Connection DBconnection = new ConnectionDB().getConnection2();
        ArrayList<HotelModel> hoteles = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

           // call.registerOutParameter(1, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                    int idHotel = rs.getInt("idHotel");

                    String name = rs.getString("name");
                    int idDisc = rs.getInt("Discount");
                    String districtH = rs.getString("District");
                    Date dateReg = rs.getDate("regDate");
                    String cantonH = rs.getString("Canton");
                    String stateH = rs.getString("State");
                    String countryH = rs.getString("Country");
                    String classi = rs.getString("classi");
                    //String clasification = rs.getString("clasification");
                    HotelModel hotelModel = new HotelModel(idHotel, name, dateReg, idDisc, classi, districtH);
                    hoteles.add(hotelModel);

                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return hoteles;
    }

    public static ArrayList<UserModel> peoplePerHotel(int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call peoplePerHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<UserModel> users = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

           // call.registerOutParameter(1, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

                    String firstName = rs.getString("name");
                    String lastName = rs.getString("lastName");
                    int idDisc = rs.getInt("Discount");
                    String districtH = rs.getString("District");
                    String cantonH = rs.getString("Canton");
                    String stateH = rs.getString("State");
                    String countryH = rs.getString("Country");
                    //   int idHotel = rs.getInt("idHotel");

                  //  HotelModel hotelModel = new HotelModel(idHotel,name, idDisc, null, districtH, cantonH, stateH, countryH);
                    //  users.add(hotelModel);
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

        return users;
    }

    public static ArrayList<HotelModel> discountPerHotel(int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call peoplePerHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<HotelModel> hoteles = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

           // call.registerOutParameter(1, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

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

        return hoteles;
    }

    public static ArrayList<HotelModel> CalificationPerHotel(int idHotel) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call peoplePerHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<HotelModel> hoteles = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

           // call.registerOutParameter(1, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {

                ResultSet rs = (ResultSet) call.getResultSet();
                while (rs.next()) {

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

        return hoteles;
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
