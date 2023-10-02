/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_manage.server;

import java.sql.Connection;
import java.sql.DriverManager;
public class DAO {
    
    private String jdbcURL = "jdbc:mysql://localhost/hotel";
    private String jdbcUsername = "root";
    private String jdbcPassword = "phong611";
    
    public DAO() {};
    
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    
    
}
