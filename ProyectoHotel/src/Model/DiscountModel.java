/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josep
 */
import java.time.LocalDate;
import java.util.Date;

public class DiscountModel {
    private Date expireDate;
    private String code;
    private double percentage;
    private String description_DSCT;

    public DiscountModel(Date expireDate, String code, double percentage, String description_DSCT) {
        this.expireDate = expireDate;
        this.code = code;
        this.percentage = percentage;
        this.description_DSCT = description_DSCT;
    }


    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getDescription_DSCT() {
        return description_DSCT;
    }

    public void setDescription_DSCT(String description_DSCT) {
        this.description_DSCT = description_DSCT;
    }
}
