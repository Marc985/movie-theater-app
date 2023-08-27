package com.example.prog2.Room;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    private  RoomRepository DAO;
    public  RoomService(RoomRepository DAO){
        this.DAO=DAO;
    }
    public List<Room> getAll(){
       return DAO.getAllRoom();
    }
    public List<Room> getById(int idRoom){
     return DAO.getRoomById(idRoom);
    }
    public void  addNewRoom(String roomName,int capacity) throws Exception{
        if(roomName==null||roomName.trim().isEmpty())
            throw new IllegalArgumentException("name of room can't be empty");
        if(capacity==0){
            throw new IllegalArgumentException("capacity of room must be precised");
        }
        DAO.addRoom(roomName,capacity);
    }

}
