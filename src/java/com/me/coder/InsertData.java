package com.me.coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author Coder ACJHP
 */
@WebService(serviceName = "InsertData", wsdlLocation = "WEB-INF/wsdl/InsertData.wsdl")
public class InsertData {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertUserData")
    public boolean insertUserData(@WebParam(name = "name") String Name, @WebParam(name = "latitude") double Latitude, @WebParam(name = "longitude") double Longitude,
            @WebParam(name = "time") String Time, @WebParam(name = "date") String Date) {
        
        boolean insertStatus = false;
        final String host = "jdbc:mysql://localhost/onurDB";
        final String user = "onur";
	final String pass = "onurdb958";
        String alan;
        
       try {
            
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Connection conn = DriverManager.getConnection(host, user, pass);
                Statement smt = conn.createStatement();
            String SQL = "INSERT INTO Google_Loc (Name, Latitude, Longitude, Time, Date) "
                    + "VALUES ('" + Name + "','" + Latitude + "','" + Longitude + "','" + Time + "','" + Date + "')";
            int x = smt.executeUpdate(SQL);
            if (x > 0) {
                insertStatus = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return insertStatus;
    }
}
