/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Querys;

import Model.HotelModel;
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

// Queries that are with joins
public class Q08TopRoomReserModel {
    String room;
    int idReservation;
    Double totalPayRoom;

    public Q08TopRoomReserModel(String idRoom, int idReservation, Double totalPayRoom) {
        this.room = idRoom;
        this.idReservation = idReservation;
        this.totalPayRoom = totalPayRoom;
    }

    public String getIdRoom() {
        return room;
    }

    public void setIdRoom(String idRoom) {
        this.room = idRoom;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Double getTotalPayRoom() {
        return totalPayRoom;
    }

    public void setTotalPayRoom(Double totalPayRoom) {
        this.totalPayRoom = totalPayRoom;
    }
    
    
    
}