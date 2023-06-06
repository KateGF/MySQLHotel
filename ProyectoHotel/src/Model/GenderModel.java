/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class GenderModel {
    private String genderName;
    private int idGender;

    public GenderModel(String genderName, int idGender) {
        this.genderName = genderName;
        this.idGender = idGender;
    }

    
    
    
    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getName() {
        return genderName;
    }

    public void setName(String gender) {
        this.genderName = gender;
    }

    public GenderModel(String gender) {
        this.genderName = gender;
    }

    
    
}
