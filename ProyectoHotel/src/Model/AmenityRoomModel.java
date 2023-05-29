/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class AmenityRoomModel {
    private String name;
    private int idHotel;
     private int idHab;

    public AmenityRoomModel(String name, int idHotel, int idHab) {
        this.name = name;
        this.idHotel = idHotel;
        this.idHab = idHab;
    }

    public int getIdHab() {
        return idHab;
    }

    public void setIdHab(int idHab) {
        this.idHab = idHab;
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
