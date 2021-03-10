package com.bdqn.service;

import com.bdqn.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();
    int orderRoom(int id,int state);
    int checkRepeat(int rno);
    int addRoom(Room r);
}
