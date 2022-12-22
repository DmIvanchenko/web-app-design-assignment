package com.ktu.xola.controller;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.Room;
import com.ktu.xola.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> findAllRooms(){
        return ResponseEntity.ok().body(roomService.findAllRooms());
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> findRoomById(@PathVariable int id){
        return ResponseEntity.ok().body(roomService.findRoomById(id));
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        return ResponseEntity.ok().body(this.roomService.createRoom(room));

    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int id,@RequestBody Room room ){
        room.setId(id);
        return ResponseEntity.ok().body(this.roomService.updateRoom(room));
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable int id){
        this.roomService.deleteRoom(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
