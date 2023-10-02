/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_manage.server;


import hotel_manage.model.Room;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author 503
 */
public class Hotel_Server {

    public Hotel_Server(){};
    public void RunServer() throws IOException, ClassNotFoundException, SQLException{
        System.out.println("Hotel Server Notification");
        RoomDAO roomDAO = new RoomDAO();
        ServerSocket ss = new ServerSocket(6969);
        while(true){
            Socket s = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Object o = ois.readObject();
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            if(o instanceof Room){
                Room room = (Room) o;
                if(!roomDAO.isRoomExisited(room)){
                    if(roomDAO.addARoom(room)){
                        System.out.println("ROOM " + room.getId() + " was added successfully");
                        dos.writeUTF("Room has been added successfully to database");
                    }else{
                        System.out.println("ROOM " + room.getId() + " was not added successfully");
                        dos.writeUTF("Something when wrong. Try again");
                    }
                }else{
                    System.out.println("ROOM " + room.getId() + " is exisited in database");
                    dos.writeUTF("Room is exisited, add another one or check your input");
                }
            }
            
        }
    }
    
}
