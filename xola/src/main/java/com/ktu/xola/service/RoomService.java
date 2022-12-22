package com.ktu.xola.service;

import com.ktu.xola.model.Car;
import com.ktu.xola.model.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room updateRoom(Room room);
    List<Room> findAllRooms();
    Room findRoomById(int roomId);
    void deleteRoom(int roomId);
}
