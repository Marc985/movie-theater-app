package com.example.prog2.Room;

import java.util.List;

public interface RoomInterfaceRepository {
    public List<Room> getAllRoom();
    public  List<Room> getRoomById(int id_room);
    public void addRoom(String roomName,int capacity) throws Exception;
}
