package com.example.prog2.Seat;

import java.util.List;

public interface SeatRepositoryInterface {
    public List<Seat> getAvailableSeatByRoomName(String roomName);
}
