package com.bdqn.service;

import com.bdqn.dao.RoomDaoImpl;
import com.bdqn.entity.Room;
import com.bdqn.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> getAll() {
        List<Room> list = null;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            if (conn != null) {
                list = new RoomDaoImpl(conn).getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, null, null);
        }
        return list;
    }

    @Override
    public int orderRoom(int id, int state) {
        int r=0;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            state=state==0?1:0;
            if (conn != null) {
                r = new RoomDaoImpl(conn).orderRoom(id,state);
                if (r>0){
                    r=state;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, null, null);
        }
        return r;
    }

    @Override
    public int checkRepeat(int rno) {
        int r=0;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            if (conn != null) {
                r = new RoomDaoImpl(conn).checkRepeat(rno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, null, null);
        }
        return r;
    }

    @Override
    public int addRoom(Room r) {
        int i=0;
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            if (conn != null) {
                i = new RoomDaoImpl(conn).addRoom(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, null, null);
        }
        return i;
    }
}
