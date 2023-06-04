/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Querys;

import Model.DiscountModel;
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
public class Q02OfferByHotelModel {
    String code;
    int percentage;
    Date expirationDate;
    
   // String Description;
    int totalAmountOffer;

    public Q02OfferByHotelModel(String code, int percentage, Date expirationDate, int totalAmountOffer) {
        this.code = code;
        this.percentage = percentage;
        this.expirationDate = expirationDate;
        this.totalAmountOffer = totalAmountOffer;
    }

    public int getTotalAmountOffer() {
        return totalAmountOffer;
    }

    public void setTotalAmountOffer(int totalAmountOffer) {
        this.totalAmountOffer = totalAmountOffer;
    }

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    
    
}