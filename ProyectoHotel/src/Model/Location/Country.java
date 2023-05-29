/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Location;

/**
 *
 * @author josep
 */
public class Country extends Location{
   

    public Country( String name) {
     
        super.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.name = name;
    }
}
