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
public class AmenityModel {
    private String name;
    private int idHotel; 
    private int idAmmenity;
    
    public AmenityModel(String name, int idHotel, int idAmmenity) {
        this.name = name;
        this.idHotel = idHotel;
        this.idAmmenity = idAmmenity;
    }

    public int getIdAmmenity() {
        return idAmmenity;
    }

    public void setIdAmmenity(int idAmmenity) {
        this.idAmmenity = idAmmenity;
    }
    
    
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    
    
    
   
}
