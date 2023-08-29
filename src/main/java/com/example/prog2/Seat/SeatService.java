package com.example.prog2.Seat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    private SeatRepository repository;
    public  SeatService(SeatRepository repository){
        this.repository=repository;
    }
    public List<Seat> getAvailableSeatByRoom(String roomName){
        return repository.getAvailableSeatByRoomName(roomName);
    }
}
