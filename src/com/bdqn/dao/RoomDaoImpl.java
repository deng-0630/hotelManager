package com.bdqn.dao;

import com.bdqn.entity.Room;
import com.bdqn.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends BaseDao implements RoomDao {
    public RoomDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public List<Room> getAll() {
        List<Room> room=null;
        ResultSet rs=null;
        try {
            rs=executeQuery("select * from room order by createdTime desc");
            if (rs != null) {
                room=new ArrayList<Room>();
                while (rs.next()){
                    Room r=new Room();
                    r.setId(rs.getInt("id"));
                    r.setRoomNo(rs.getInt("roomNo"));
                    r.setRoomType(rs.getString("roomType"));
                    r.setPeopleConut(rs.getInt("peopleCount"));
                    r.setRent(rs.getFloat("rent"));
                    r.setIsRental(rs.getInt("isRental"));
                    r.setCreateTime(rs.getDate("createdTime"));
                    r.setUpdatedTime(rs.getDate("updatedTime"));
                    room.add(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(null,null,rs);
        }

        return room;
    }

    @Override
    public int orderRoom(int id, int state) {
        int r=0;
        try {
            r=executeNonQuery("update room set isRental=? where id=?",state,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public int checkRepeat(int rno) {
        int r=0;
        ResultSet rs=null;
        try {
            rs=executeQuery("select count(*) from room where roomNo=?",rno);
            if (rs.next()) {
                r=rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;

    }

    @Override
    public int addRoom(Room r) {
        int i=0;
        try {
            i=executeNonQuery("insert into  room values(null,?,?,?,?,?,?,?)",
                    r.getRoomNo(),r.getRoomType(),r.getPeopleConut(),r.getRent(),r.getIsRental(),r.getCreateTime(),r.getUpdatedTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
