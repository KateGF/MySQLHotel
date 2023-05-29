/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class CategoryModel {
   
    private int idroomcategory;
    private String name;
    
    public CategoryModel(int idroomcategory,  String name) {
        this.name = name;
        this.idroomcategory = idroomcategory;
       
    }

    public int getIdroomcategory() {
        return idroomcategory;
    }

    public void setIdroomcategory(int idroomcategory) {
        this.idroomcategory = idroomcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
