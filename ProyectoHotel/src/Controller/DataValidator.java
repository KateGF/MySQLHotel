/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.HotelModel;
import Model.Response;
import Model.UserModel;

/**
 *
 * @author guzka
 */
public class DataValidator {
    
  
    private static boolean is_text_valid(String text){
        return !(text.isEmpty() || text.isEmpty());
    }
    
    /**
     * Valida un objeto persona.
     * @param person
     * @return 
     */
    public static Response validate_user(UserModel user){
        
        // Se verifica que el nombre no este vacío.
        if (!DataValidator.is_text_valid(user.getFirstName())){
            return new Response(Response_code.ERROR, "Error, debe ingresar el nombre.");
        }
        
        // Se verifica que el apellido no este vacío.
        if (!DataValidator.is_text_valid(user.getLastName())){
            return new Response(Response_code.ERROR, "Error, debe ingresar el apellido.");
        }
        
        return new Response(Response_code.SUCCESS);
    }

    static Response validate_hotel(HotelModel hotel) {
          // Se verifica que el nombre no este vacío.
        if (!DataValidator.is_text_valid(hotel.getName())){
            return new Response(Response_code.ERROR, "Error, debe ingresar el nombre.");
        }
        
        return new Response(Response_code.SUCCESS);
    }
    
    
}
