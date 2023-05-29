/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class ReservationModel {
    private int idPayment;
    private int idPenalty;
    private int idUser;
    private int idReservation;
    private int adminPrice;
    private String firstName;
    private String roomName;
    private int idHotel;
    private String hotelName;
    private String category;
    private int idRoom;
    private String namePayment;
    private int capacity;

    public ReservationModel(int idUser, int idReservation, int adminPrice, String firstName,
            String roomName, int idHotel, String hotelName, String category, int idRoom, 
            String namePayment,int capacity) {
        this.idUser = idUser;
        this.idReservation = idReservation;
        this.adminPrice = adminPrice;
        this.firstName = firstName;
        this.roomName = roomName;
        this.idHotel = idHotel;
        this.hotelName = hotelName;
        this.category = category;
        this.idRoom = idRoom;
        this.namePayment = namePayment;
        this.capacity = capacity;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getAdminPrice() {
        return adminPrice;
    }

    public void setAdminPrice(int adminPrice) {
        this.adminPrice = adminPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdPenalty() {
        return idPenalty;
    }

    public void setIdPenalty(int idPenalty) {
        this.idPenalty = idPenalty;
    }
    
    @Override
    public String toString(){
        return   "[" +this.idReservation + "]  Hotel: "     + this.hotelName + "  Room:" + this.roomName;
    }
}
