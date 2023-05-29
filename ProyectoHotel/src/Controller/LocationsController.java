/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Location.Location;
import Model.Location.Country;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author guzka
 */
public class LocationsController {

    public static ArrayList<Location> getLocations(String type) {
        String statement = "";
        String column = "";
        switch (type) {

            case "Country":
                statement = "{call getCountries(?)}";
                column = "idCountry";
                break;

            case "State":
                statement = "{call getStates(?)}";
                 column = "idState";
                break;

            case "Canton":
                statement = "{call getCantons(?)}";
                 column = "idCanton";
                break;

            case "District":
                statement = "{call getDistricts(?)}";
                 column = "idDistrict";
                break;

        }

        Connection DBconnection = new ConnectionDB().getConnection();
        ArrayList<Location> countries = new ArrayList<>();
        try {

            CallableStatement call = DBconnection.prepareCall(statement);

            call.registerOutParameter(1, OracleTypes.CURSOR);
            call = queryData(call);

            if (call != null) {
                ResultSet rs = (ResultSet) call.getObject(1);

                while (rs.next()) {
                    String name = rs.getString("name");
                    int id = rs.getInt(column);
                    Location location = new Location();
                    location.setName(name);
                    location.setID(id);
                    countries.add(location);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);
            // new Response(Response_code.ERROR, "Ocurrió un error inesperado, intente de nuevo.");
        }
        //new Response(Response_code.SUCCESS, "Persona obtenida exitosamente.");
        return countries;
    }

    /**
     * Recibe una llamada parametrizada y la manda a ejecutar a la base de
     * datos.
     *
     * @param call
     * @return retorna el objeto de llamada.
     */
    private static CallableStatement insertData(CallableStatement call) {
        try {
            call.executeQuery();
            return call;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Recibe una consulta parametrizada y la manda a ejecutar a la base de
     * datos.
     *
     * @param call
     * @return retorna el objeto de llamada.
     */
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
