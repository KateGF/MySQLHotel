/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class AmenityxHotelModel {

    
    private int idRoom;
    private int idAmenity;
    

    public AmenityxHotelModel( int idHotel, int idHab) {
       
        this.idRoom = idHotel;
        this.idAmenity = idHab;
    }

    public int getIdHab() {
        return idAmenity;
    }

    public void setIdHab(int idHab) {
        this.idAmenity = idHab;
    }

   
    public int getIdHotel() {
        return idRoom;
    }

    public void setIdHotel(int idHotel) {
        this.idRoom = idHotel;
    }
}
