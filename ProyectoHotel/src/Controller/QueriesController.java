/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.DiscountModel;
import Model.HotelModel;
import Model.Location.Location;
import Model.Querys.Q01PeopleByHotelModel;
import Model.Querys.Q02OfferByHotelModel;
import Model.Querys.Q06TotalHotelModel;
import Model.Response;
import Model.UserModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guzka
 */
public class QueriesController {

    
    public static ArrayList<UserModel> peoplePerHotel(int idHotel, String ordenBy) {
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

    public static ArrayList<Q02OfferByHotelModel> offerByHotel(int idHotel ) {
        ArrayList<Q02OfferByHotelModel> offers = new ArrayList<>();
        
        String statement = "{call getDiscountTotalByHotel(?)}"; 
       
        
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            
          
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String code = rs.getString("Code");
                    int percentage = rs.getInt("Percentage");
                    Date expireDate = rs.getDate("ExpireDate");
                    int sum = rs.getInt("sum");
                      
                    Q02OfferByHotelModel discount = new Q02OfferByHotelModel(code, percentage, expireDate,sum);
                    offers.add(discount);

                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return offers;
    }

    
    public static ArrayList<Q02OfferByHotelModel> offerByHotelDate(int idHotel, Date d1, Date d2 ) {
        ArrayList<Q02OfferByHotelModel> offers = new ArrayList<>();
        
        String statement = "{call offerByHotel(?,?,?)}"; 
       
        
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            
            //call.setString(2, discount.getCode());
            java.sql.Date d11 = new java.sql.Date(d1.getTime());
            call.setDate(2, d11);
            
             //call.setString(2, discount.getCode());
            java.sql.Date d22 = new java.sql.Date(d1.getTime());
            call.setDate(2, d22);
            
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String code = rs.getString("Code");
                    int percentage = rs.getInt("Percentage");
                    Date expireDate = rs.getDate("ExpireDate");
                    int sum = rs.getInt("sum");
                      
                    Q02OfferByHotelModel discount = new Q02OfferByHotelModel(code, percentage, expireDate,sum);
                    offers.add(discount);

                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return offers;
    }

    public static ArrayList<Q02OfferByHotelModel> offerByHotelCode(int idHotel, Date d1, Date d2, String ccode ) {
        ArrayList<Q02OfferByHotelModel> offers = new ArrayList<>();
        String statement;
        if(ccode!=""){
            statement = "{call offerByHotel(?,?,?)}"; 
        }
        else{
             statement = "{call offerByName(?,?,?,?)}";
        }
        
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            
            //call.setString(2, discount.getCode());
            java.sql.Date d11 = new java.sql.Date(d1.getTime());
            call.setDate(2, d11);
            
             //call.setString(2, discount.getCode());
            java.sql.Date d22 = new java.sql.Date(d1.getTime());
            call.setDate(2, d22);
            
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String code = rs.getString("Code");
                    int percentage = rs.getInt("Percentage");
                    Date expireDate = rs.getDate("ExpireDate");
                    int sum = rs.getInt("sum");
                    Q02OfferByHotelModel discount = new Q02OfferByHotelModel(code, percentage, expireDate, sum);
                    offers.add(discount);

                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return offers;
    }

    // FALTA
    public static ArrayList<Location> calificationAv(int idHotel) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getPeopleByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
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
    // FALTA
    public static ArrayList<Location> topNMoreRes(int idHotel) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getPeopleByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
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
    // FALTA
    public static ArrayList<Location> topNLessRes(int idHotel) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getPeopleByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
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

     public static ArrayList<Q06TotalHotelModel> totalHotel(int idHotel) {
        ArrayList<Q06TotalHotelModel> totalHotel = new ArrayList<>();
        
        String statement = "{call getRoomsReservfromHotelAll()}"; 
       
        
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("Name");
                    int rooms = rs.getInt("rooms");
                    int reserv = rs.getInt("reservations");
                    int sumR = rs.getInt("sum");
                      
                    Q06TotalHotelModel totalReserv = new Q06TotalHotelModel(rooms, sumR, name, reserv);
                    totalHotel.add(totalReserv);

                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return totalHotel;
    }

     
     // FALTA
     public static ArrayList<Location> clientByAge(int idHotel) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getPeopleByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
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
     
     // FALTA
      public static ArrayList<Location> topRoomReserv(int idHotel) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getPeopleByHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
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
