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
public class Q08TopRoomReser {
    int idRoom;
    int idReservation;
    int totalPayRoom;

    public Q08TopRoomReser(int idRoom, int idReservation, int totalPayRoom) {
        this.idRoom = idRoom;
        this.idReservation = idReservation;
        this.totalPayRoom = totalPayRoom;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getTotalPayRoom() {
        return totalPayRoom;
    }

    public void setTotalPayRoom(int totalPayRoom) {
        this.totalPayRoom = totalPayRoom;
    }
    
    
    
}