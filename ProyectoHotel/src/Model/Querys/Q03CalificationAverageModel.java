/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Querys;

import java.util.Date;

/**
 *
 * @author guzka
 */

// Queries that are with joins
public class Q03CalificationAverageModel {
    String name;
    String review;
    Date checkIn;
    //Date checkOut;
    String comments;

    public Q03CalificationAverageModel(String name, String review, Date checkIn, String comments) {
        this.name = name;
        this.review = review;
        this.checkIn = checkIn;
      //  this.checkOut = checkOut;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String lastName) {
        this.review = lastName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

 

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

   
}