package com.bdqn.dao;

import com.bdqn.entity.Room;

import java.util.List;

public interface RoomDao {
    //返回所有房间信息
    List<Room> getAll();
    int orderRoom(int id,int state);
    int checkRepeat(int rno);
    int addRoom(Room r);

}
