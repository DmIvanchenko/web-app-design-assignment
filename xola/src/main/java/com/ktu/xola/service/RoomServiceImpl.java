package com.ktu.xola.service;

import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.Car;
import com.ktu.xola.model.Room;
import com.ktu.xola.repository.HotelRepository;
import com.ktu.xola.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Room createRoom(Room room) {
        if (hotelRepository.findById(room.getHotel()).isPresent()) {
            return roomRepository.save(room);
        }else {
            throw new ResourceNotFoundException("Record not found " + room.getId());
        }
    }

    @Override
    public Room updateRoom(Room room) {
        Optional<Room> roomDb = this.roomRepository.findById(room.getId());
        if(roomDb.isPresent()){
            Room updatedRoom = roomDb.get();
            updatedRoom.setId(room.getId());
            updatedRoom.setNumberOfGuests(room.getNumberOfGuests());
            updatedRoom.setHotel(room.getHotel());
            return updatedRoom;
        }else {
            throw new ResourceNotFoundException("Record not found " + room.getId());
        }
    }

    @Override
    public List<Room> findAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room findRoomById(int roomId) {
        Optional<Room> roomDb = this.roomRepository.findById(roomId);
        if (roomDb.isPresent()){
            return roomDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + roomId);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        Optional<Room> roomDb = this.roomRepository.findById(roomId);
        if (roomDb.isPresent()){
            this.roomRepository.delete(roomDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + roomId);
        }
    }
}
