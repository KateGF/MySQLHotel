/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Constants.Response_code;
import Model.HotelModel;
import Model.Location.Location;
import Model.Response;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guzka
 */
public class LocationsController {

    public static ArrayList<Location> getCountries() {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getCountries()}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            
            if(DBconnection != null){
                 // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);

            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idCountry");
                    Location location = new Location();
                    location.setName(name);
                    location.setID(idX);
                    locations.add(location);
                }
            }

            call.getConnection().close();
            call.close();
            }else{
                
            }
           

        } catch (SQLException e) {
            System.out.println(e);

        }
        return locations;
    }

    public static ArrayList<Location> getStatesByCountry(int idCountry) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getStateByCountry(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idCountry);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idState");
                    Location location = new Location();
                    location.setName(name);
                    location.setID(idX);
                    locations.add(location);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return locations;
    }

    public static ArrayList<Location> getCantonsByState(int id) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getCantonsByState(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, id);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idCanton");
                    Location location = new Location();
                    location.setName(name);
                    location.setID(idX);
                    locations.add(location);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return locations;
    }

    public static ArrayList<Location> getDistrictsByCanton(int id) {
        ArrayList<Location> locations = new ArrayList<>();
        String statement = "{call getDistrictsByCanton(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, id);
            call = queryData(call);
            if (call != null) {
                ResultSet rs = (ResultSet) call.getResultSet();

                while (rs.next()) {
                    String name = rs.getString("name");
                    int idX = rs.getInt("idDistrict");
                    Location location = new Location();
                    location.setName(name);
                    location.setID(idX);
                    locations.add(location);
                }
            }

            call.getConnection().close();
            call.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
        return locations;
    }

    public static String addCountry(String name, String username) {
        String statement = "{call insert_Country(?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            if(DBconnection!= null){
               // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, name);
            //call.setString(2, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Inserted";
            } else {
                return "Not inserted";
            }  
            }else{
                 return "No DB Connect";
            }
           

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }

    }

    public static String addState(String name, int idCountry, String username) {
        String statement = "{call insert_State(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, name);
            call.setInt(2, idCountry);
            //call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Inserted";
            } else {
                return "Not inserted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String addCanton(String name, int idState, String username) {
        String statement = "{call insert_Canton(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, name);
            call.setInt(2, idState);
            //call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Inserted";
            } else {
                return "Not inserted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String addDistrict(String name, int idCanton, String username) {
        String statement = "{call insert_District(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, name);
            call.setInt(2, idCanton);
            //call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Inserted";
            } else {
                return "Not inserted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String editCountry(String newName, int idCountry, String username) {
        String statement = "{call editCountry(?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, newName);
            call.setInt(2, idCountry);
            call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Edited";
            } else {
                return "Not edited";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String editState(String newName, int idState, String username) {
        String statement = "{call editState(?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, newName);
            call.setInt(2, idState);
            call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Edited";
            } else {
                return "Not edited";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String editCanton(String newName, int idCountry, String username) {
        String statement = "{call editCanton(?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, newName);
            call.setInt(2, idCountry);
            call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Edited";
            } else {
                return "Not edited";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String editDistrict(String newName, int idCountry, String username) {
        String statement = "{call editDistrict(?,?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setString(1, newName);
            call.setInt(2, idCountry);
            call.setString(3, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Edited";
            } else {
                return "Not edited";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String deleteCountry(int idCountry, String username) {
        String statement = "{call deleteCountry(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idCountry);
            call.setString(2, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Deleted";
            } else {
                return "Not deleted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String deleteState(int idState, String username) {
        String statement = "{call deleteCountry(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idState);
            call.setString(2, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Deleted";
            } else {
                return "Not deleted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String deleteCanton(int idCanton, String username) {
        String statement = "{call deleteCanton(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idCanton);
            call.setString(2, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Deleted";
            } else {
                return "Not deleted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
    }

    public static String deleteDistrict(int idDistrict, String username) {
        String statement = "{call deleteDistrict(?,?)}";
        Connection DBconnection = new ConnectionDB().getConnection();
        try {

            // Se crea una llamada parametrizada.
            CallableStatement call = DBconnection.prepareCall(statement);
            call.setInt(1, idDistrict);
            call.setString(2, username);
            call = insertData(call);
            if (call != null) {
                call.getConnection().close();
                call.close();
                return "Deleted";
            } else {
                return "Not deleted";
            }

        } catch (SQLException e) {
            System.out.println(e);
            return "Error: " + e;
        }
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
