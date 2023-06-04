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
public class Q05TopNLessReservation {
     int numLessReservations;
    Date date;

    public Q05TopNLessReservation(int numLessReservations, Date date) {
        this.numLessReservations = numLessReservations;
        this.date = date;
    }

    public int getNumLessReservations() {
        return numLessReservations;
    }

    public void setNumLessReservations(int numLessReservations) {
        this.numLessReservations = numLessReservations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}