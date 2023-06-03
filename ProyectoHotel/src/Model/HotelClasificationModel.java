/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author guzka
 */
public class HotelClasificationModel {
    int idClasification;
    String name;

    public HotelClasificationModel(int idClasification, String name) {
        this.idClasification = idClasification;
        this.name = name;
    }

    public int getIdClasification() {
        return idClasification;
    }

    public void setIdClasification(int idClasification) {
        this.idClasification = idClasification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
