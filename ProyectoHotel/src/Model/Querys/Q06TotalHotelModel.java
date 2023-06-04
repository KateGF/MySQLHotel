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
public class Q06TotalHotelModel {
    int totalRooms;
    int totalReserv;
    int totalPaid;
    String hotelName;
    int idHotel;

    public Q06TotalHotelModel(int totalRooms, int totalPaid, String hotelName, int reservations) {
        this.totalRooms = totalRooms;
        this.totalPaid = totalPaid;
        this.hotelName = hotelName;
        this.totalReserv = reservations;

    }

    public int getTotalReserv() {
        return totalReserv;
    }

    public void setTotalReserv(int totalReserv) {
        this.totalReserv = totalReserv;
    }

    
    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    
    
    

}