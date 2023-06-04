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
public class Q02OfferByHotel {
    String offerName;
    Date startDate;
    Date finishDate;
    String Description;
    int totalAmountOffer;

    public Q02OfferByHotel(String offerName, Date startDate, Date finishDate, String Description, int totalAmountOffer) {
        this.offerName = offerName;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.Description = Description;
        this.totalAmountOffer = totalAmountOffer;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getTotalAmountOffer() {
        return totalAmountOffer;
    }

    public void setTotalAmountOffer(int totalAmountOffer) {
        this.totalAmountOffer = totalAmountOffer;
    }
 
    
    
}