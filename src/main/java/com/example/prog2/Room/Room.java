package com.example.prog2.Room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Room {

   private int id_room;

   private String roomName;

   private int capacity;
}
