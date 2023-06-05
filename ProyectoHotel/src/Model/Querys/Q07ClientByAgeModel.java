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
public class Q07ClientByAgeModel {
    String range;
    int total;
    String nameGender;

    public Q07ClientByAgeModel(String range, int total, String nameGender) {
        this.range = range;
        this.total = total;
        this.nameGender = nameGender;
    }

   
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }

    public Q07ClientByAgeModel(String range, int total) {
        this.range = range;
        this.total = total;
    }

    
}