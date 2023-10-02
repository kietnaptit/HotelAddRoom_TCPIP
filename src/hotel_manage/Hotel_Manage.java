/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_manage;

import hotel_manage.client.Hotel_Client_View;
import hotel_manage.server.Hotel_Server;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author 503
 */
public class Hotel_Manage {

    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Hotel_Client_View hotel_Client_View = new Hotel_Client_View();
        hotel_Client_View.setVisible(true);
        Hotel_Server hotel_Server = new Hotel_Server();
        hotel_Server.RunServer();
    }
    
}
