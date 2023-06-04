/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.DiscountModel;
import Model.Response;
import Model.Review;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guzka
 */
public class DiscountController {

   
    public static Response insertDiscount(Date expireDate,String code,Double percentage,int idHotel) {
      
        String statement = "{call insert_discounthotel(?,?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

          
            CallableStatement call = DBconnection.prepareCall(statement);
        
            call.setDate(1, new java.sql.Date(expireDate.getTime()));
            call.setString(2, code);
            call.setDouble(3, percentage);
            call.setInt(4, idHotel);
            call = insertData(call);

            if (call == null) {
                return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
            }

       
            call.getConnection().close();
            call.close();

           
            return new Response(Response_code.SUCCESS, "Discount registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println(e);
            return new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
    }
     
    public static ArrayList<DiscountModel> getDiscountsHotel(int idHotel) {
        String statement = "{call getDiscountsHotel(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<DiscountModel> discounts = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idHotel);
            //call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    int idDiscount = rs.getInt("idDiscount");
                    Date expireDate = rs.getDate("expireDate");
                    String code = rs.getString("code");
                    Double percentage = Double.parseDouble(rs.getString("percentage"));
                    //String description = rs.getString("description");
                  
                    DiscountModel revi = new DiscountModel(expireDate, percentage, code, "", idDiscount,idHotel);
                    discounts.add(revi);
                }
                
                 call.getConnection().close();
                call.close();
            }

           

        } catch (SQLException e) {
            System.out.println(e);
        }
        return discounts;
    }
    public static ArrayList<DiscountModel> getDiscounts() {
        String statement = "{call getDiscounts()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<DiscountModel> discounts = new ArrayList<>();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            //call.registerOutParameter(2, OracleTypes.CURSOR);

            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    int idDiscount = rs.getInt("idDiscount");
                    Date expireDate = rs.getDate("expireDate");
                    String code = rs.getString("code");
                    Double percentage = Double.parseDouble(rs.getString("percentage"));
                    //String description = rs.getString("description");
                    int idHotel = rs.getInt("idHotel");
                    DiscountModel revi = new DiscountModel(expireDate, percentage, code, "", idDiscount,idHotel);
                    discounts.add(revi);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return discounts;
    }
    private static CallableStatement insertData(CallableStatement call) {
        try {
            call.executeQuery();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    private static CallableStatement queryData(CallableStatement call) {
        try {
            call.execute();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    
    
    
}
