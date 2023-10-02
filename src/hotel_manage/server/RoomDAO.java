/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_manage.server;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import hotel_manage.model.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 503
 */
public class RoomDAO {
    private DAO dao = new DAO();
    public RoomDAO(){};
    private static final String ADD_A_ROOM = "INSERT INTO room VALUES (?, ?, ?, ?)";
    private static final String CHECK_ROOM_EXSITS = "SELECT * FROM room WHERE id = ? OR name = ?";
    private static final String GET_ALL_ROOM = "SELECT * FROM room";
    
    public boolean addARoom(Room room){
        boolean success = false;
        
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_A_ROOM);
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setString(2, room.getName());
            preparedStatement.setString(3, room.getType());
            preparedStatement.setInt(4, room.getPrice());
            preparedStatement.execute();
            preparedStatement.close();
            success = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return success;
    }
    
    public boolean isRoomExisited(Room room) throws SQLException{
        boolean exisited = false;
        
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ROOM_EXSITS);
            preparedStatement.setInt(1, room.getId());
            preparedStatement.setString(2, room.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                exisited = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return exisited;
    }
    
    public List<Room> listAllRoom(){
        List<Room> rooms = new ArrayList<>();
        try{
            Connection connection = dao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROOM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int price = resultSet.getInt("price");
                Room room = new Room(id, name, type, price);
                rooms.add(room);
                        
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rooms;
    }
    
}
