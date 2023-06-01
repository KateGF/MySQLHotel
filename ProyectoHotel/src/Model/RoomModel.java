/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class RoomModel {
    private String name;
    private int capacity;
    private int recommendedPrice;
    private int idHotel;
    private int idRoomCategory;
    private int idRoom;
    
    private String categoryName;
    
    public RoomModel(int idRoom, String name, int capacity, int recommendedPrice, int idHotel, int idRoomCategory) {
        this.idRoom = idRoom;
        this.name = name;
        this.capacity = capacity;
        this.recommendedPrice = recommendedPrice;
        this.idHotel = idHotel;
        this.idRoomCategory = idRoomCategory;
    }
    
    public RoomModel(int idRoom, String name, int capacity, int recommendedPrice, int idHotel, String roomCategory) {
        this.idRoom = idRoom;
        this.name = name;
        this.capacity = capacity;
        this.recommendedPrice = recommendedPrice;
        this.idHotel = idHotel;
        this.categoryName = roomCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    
    
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(int recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }

    public int getIdHotel() {
        return this.idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getIdRoomCategory() {
        return idRoomCategory;
    }

    public void setIdRoomCategory(int idRoomCategory) {
        this.idRoomCategory = idRoomCategory;
    }
}
