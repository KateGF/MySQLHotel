/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
public class GenreModel {
    private String genre;
    private int idGenre;

    public GenreModel(String comment, int idReservation) {
        this.genre = comment;
        this.idGenre = idReservation;
    }



    public String getComment() {
        return genre;
    }

    public void setComment(String comment) {
        this.genre = comment;
    }

    public int getIdReservation() {
        return idGenre;
    }

    public void setIdReservation(int idReservation) {
        this.idGenre = idReservation;
    }
}
