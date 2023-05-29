/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Location;

/**
 *
 * @author guzka
 */
public class Location {
    String name;
    int id;
  

   
    public void setName(String name) {
        this.name = name;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
       return this.name;
    }
    
    public int getID() {
       return this.id;
    }
    
}
