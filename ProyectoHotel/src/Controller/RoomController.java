/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.CategoryModel;
import Model.Response;
import Model.RoomModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guzka
 */
public class RoomController {

    public static Response insertRoom(RoomModel room) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insert_room(?,?,?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call.setString(1, room.getName());
            call.setInt(2, room.getCapacity());
            call.setInt(3, room.getRecommendedPrice());
            call.setInt(4, room.getIdHotel());
            call.setInt(5, room.getIdRoomCategory());
            
            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

            call.getConnection().close();
            call.close();

            return new Response(Response_code.SUCCESS, "Habitacion registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }

    public static ArrayList<RoomModel> getRooms(int idHotel) {
        String statement = "{call getRoomFromHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<RoomModel> rooms = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call.setInt(1, idHotel);
            //call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {

                    String name = rs.getString("roomname");
                    int capacity = rs.getInt("capacity");
                    int recommendedPrice = rs.getInt("recommendedPrice");
                    String idRoomCategory = rs.getString("category");
                    int idRoom = rs.getInt("idRoom");

                    RoomModel room = new RoomModel(idRoom, name, capacity, recommendedPrice, idHotel, idRoomCategory);
                    rooms.add(room);
                }
                 call.getConnection().close();
                call.close();
            }

           

        } catch (SQLException e) {
            System.out.println(e);
        }
        return rooms;
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

    public static ArrayList<CategoryModel> getCategories() {

        String statement = "{call getCategories()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<CategoryModel> categories = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            //call.registerOutParameter(1, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {

                    String name = rs.getString("name");
                    int idroomcategory = rs.getInt("idroomcategory");
                    categories.add(new CategoryModel(idroomcategory, name));
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return categories;

    }

}
