/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author guzka
 */
public class UserModel {
    String photo;
    String identificationCard;
    String firstName;
    String lastName;
    String secondSurname;
    String middleName;
    String username;
    String password;
    Date  birthdate;
    int gender;
    String phoneNumber;
    String nationality;
    int country;
    int state;
    int canton;
    int district;
    int idUserType;
    int idType;
    int idHotelAdmin;
    int idUser;

    public UserModel(int idUser,String firstName, String username, String password, int idUserType) {
         this.idUser = idUser;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.idUserType = idUserType;
        // add idUser
    }

    public UserModel(int idUser,String photo, String identificationCard, String firstName, String lastName, 
            String secondSurname, String middleName, String username, String password, Date birthdate, 
            int gender, int district, int idUserType, int idType, int idHotelAdmin) {
        this.idUser = idUser;
        this.photo = photo;
        this.identificationCard = identificationCard;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondSurname = secondSurname;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.district = district;
        this.idUserType = idUserType;
        this.idType = idType;
        this.idHotelAdmin = idHotelAdmin;
    }
    
    
    
    public UserModel(String photo, String identificationCard, String firstName, String lastName, String secondSurname, String middleName, String username, String password, Date birthdate, int gender, String phoneNumber, String nationality, int country, int state, int canton, int district, int idUserType, int idType, int idHotelAdmin) {
        this.photo = photo;
        this.identificationCard = identificationCard;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondSurname = secondSurname;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.nationality = nationality;
        this.country = country;
        this.state = state;
        this.canton = canton;
        this.district = district;
        this.idUserType = idUserType;
        this.idType = idType;
        this.idHotelAdmin = idHotelAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

   

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
    
    
    
     // constr de usuario paso un string

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
        this.canton = canton;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(int idUserType) {
        this.idUserType = idUserType;
    }

    public int getIdHotelAdmin() {
        return idHotelAdmin;
    }

    public void setIdHotelAdmin(int idHotelAdmin) {
        this.idHotelAdmin = idHotelAdmin;
    }
}
