/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author josep
 */
public class HotelModel {
    
    private String name;
    private int idHotel;
    private Date registerDate;
    
    private int idDistrict;
    private int idDiscount;
    private int idClassification;
    
    private String district;
    private String canton;
    private String state;
    private String country;
    private String clasification ;

     public HotelModel(int idHotel,String name,Date registerDate, int idDiscount, int clasification, int district) {
        this.idHotel = idHotel;
        this.name = name;
        this.idDiscount = idDiscount;
        this.idDistrict = district;
        this.idClassification = clasification;
    }

    
    
    public HotelModel(int idHotel,String name,Date registerDate, int idDiscount, String clasification, String district) {
        this.idHotel = idHotel;
        this.name = name;
        this.idDiscount = idDiscount;
        this.district = district;
       
        this.clasification = clasification;
    }

    public String getClasification() {
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
    }
    
    

    public int getDiscount() {
        return idDiscount;
    }

    public void setDiscount(int discount) {
        this.idDiscount = discount;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    public HotelModel(String name, Date registerDate, int idDistrict, int idDiscount) {
        this.name = name;
        this.registerDate = registerDate;
        this.idDistrict = idDistrict;
        this.idDiscount = idDiscount;
    }
       public HotelModel(int idHotel, String name, Date registerDate, int idDistrict, int idDiscount) {
           this.idHotel = idHotel;
        this.name = name;
        this.registerDate = registerDate;
        this.idDistrict = idDistrict;
        this.idDiscount = idDiscount;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    // Setter and getter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // Setter and getter for registerDate
    public Date getRegisterDate() {
        return registerDate;
    }
    
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    // Setter and getter for idDistrict
    public int getIdDistrict() {
        return idDistrict;
    }
    
    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    // Setter and getter for idDiscount
    public int getIdDiscount() {
        return idDiscount;
    }
    
    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }
}
