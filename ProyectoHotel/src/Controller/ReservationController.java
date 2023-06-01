/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.HotelModel;
import Model.ReservationModel;
import Model.ReservationXRoomModel;
import Model.Response;
import Model.RoomModel;
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
public class ReservationController {

    public static Response insertReservation(HotelModel hotel,
            ReservationXRoomModel ReservationxRoom, UserModel user, int idPayment) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call insert_reservationAll(?,?,?,?,?,?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        // set from table

            call.setInt(1, user.getIdUser());
            call.setInt(2, idPayment);
            //Penalty
            call.setInt(3, 1);
            int adminPrice = ReservationxRoom.getAdminPrice();
            call.setInt(4,adminPrice );
            java.sql.Date sqlDateCheckIn = new java.sql.Date(ReservationxRoom.getCheckIn().getTime());
            call.setDate(5, sqlDateCheckIn);
            long time = ReservationxRoom.getCheckOut().getTime();
            java.sql.Date sqlDateCheckOut = new java.sql.Date(time);
            call.setDate(6, sqlDateCheckOut);
            call.setInt(7, ReservationxRoom.getIdRoom());
            call.setInt(8, ReservationxRoom.getIdDiscount());

            call = queryData(call);

            call.getConnection().close();
            call.close();

            return new Response(Response_code.SUCCESS, "Habitacion registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }

    // DELETE RESERVATION
    public static Response deleteReservation(int idReservation) {
        // Para construir una llamada parametrizada, coloque el nombre del procedimiento
        // y entre los paréntesis van símbolos de pregunta '?', que son los parámetros del procedimiento.
        String statement = "{call delete_reservation(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
        // set from table

            call.setInt(1, idReservation);

            call = deleteData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

            call.getConnection().close();
            call.close();

            return new Response(Response_code.SUCCESS, "Reservacion eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }

    public static ArrayList<ReservationModel> getReservations(int idUser) {
        String statement = "{call getReservationsFromUser(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<ReservationModel> reservations = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call.setInt(1, idUser);
            call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getObject(2);

                while (rs.next()) {

                    int iduser = rs.getInt("idUser");
                    int idReservation = rs.getInt("idReservation");
                    int adminPrice = rs.getInt("adminPrice");
                    String firstName = rs.getString("firstName");
                    String roomName = rs.getString("Room");
                    String category = rs.getString("roomcategory");
                    int idRoom = rs.getInt("idRoom");
                    int idhotel = rs.getInt("idHotel");
                    String hotelName = rs.getString("hotelName");
                    int capacity = rs.getInt("capacity");
                    String paymentName = rs.getString("namePaymentMethod");

                    ReservationModel reserv = new ReservationModel(idUser, idReservation, adminPrice, 
                            firstName, roomName, idhotel, hotelName,category,idRoom,paymentName,capacity);
                    reservations.add(reserv);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reservations;
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

    private static CallableStatement deleteData(CallableStatement call) {
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
            call.executeQuery();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
