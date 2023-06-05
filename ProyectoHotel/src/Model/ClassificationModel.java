/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class ClassificationModel {
   
    private int idClassification;
    private String name;
    
    public ClassificationModel(int idclass,  String name) {
        this.name = name;
        this.idClassification = idclass;
       
    }

    public int getIdclass() {
        return idClassification;
    }

    public void setIdclass(int idroomcategory) {
        this.idClassification = idroomcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
