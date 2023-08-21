package com.example.prog2.Room;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RoomController {
private RoomService service;
public  RoomController(RoomService service){
    this.service=service;
}
@GetMapping(path="/room")
    public List<Room> getAllRooms() throws  Exception{
    return service.getAll();
}
@GetMapping("/room/{idRoom}")
    public List<Room> getRoomById(@PathVariable int idRoom) throws Exception{
    return service.getById(idRoom);
}
@PostMapping("/room")
    public ResponseEntity<?> CreateRoom(@RequestBody Room room){
    try {
        service.addNewRoom(room.getRoomName(), room.getCapacity());
        return ResponseEntity.status(HttpStatus.CREATED).body("the room is created succefully.");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error catch : " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("the room isn't created");
    }

}


}
