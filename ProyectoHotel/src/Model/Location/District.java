/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Location;

/**
 *
 * @author josep
 */
public class District  extends Location {
 
    private int idCanton;

    public District( String name, int idCanton) {
        super.name = name;
      
        this.idCanton = idCanton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }
}
