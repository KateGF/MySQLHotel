/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author guzka
 */
public class ReservationXRoomModel {
     int adminPrice;
     Date checkIn;
     Date checkOut;
     int idReservation;
     int idRoom;
     int idDiscount;

    public ReservationXRoomModel(int adminPrice, Date checkIn, Date checkOut, int idReservation, int idRoom, int idDiscount) {
        this.adminPrice = adminPrice;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.idReservation = idReservation;
        this.idRoom = idRoom;
        this.idDiscount = idDiscount;
    }

    public int getAdminPrice() {
        return this.adminPrice;
    }

    public void setAdminPrice(int adminPrice) {
        this.adminPrice = adminPrice;
    }

    public Date getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getIdReservation() {
        return this.idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdRoom() {
        return this.idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdDiscount() {
        return this.idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }
     
     
     
     
     
     
    
}
