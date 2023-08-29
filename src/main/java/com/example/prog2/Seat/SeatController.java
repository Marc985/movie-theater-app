package com.example.prog2.Seat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {
    SeatService service;
    public SeatController(SeatService service){
        this.service=service;
    }
     @GetMapping("/seat/{roomName}")
    public List<Seat> findAvailableSeat(@PathVariable String roomName){
        return service.getAvailableSeatByRoom(roomName);
    }
}
