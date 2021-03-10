package com.bdqn.dao;

import com.bdqn.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//dao父類
public abstract class BaseDao {
    //鏈接對象
    private Connection conn;
    //構造方法

    public BaseDao(Connection conn) {
        this.conn = conn;
    }
    //執行查詢語句
    public ResultSet executeQuery(String sql, Object... args){
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            //把參數綁定到表達式對象
            if (args!=null){
                int i=1;
                for (Object arg:args){
                    pstmt.setObject(i++,arg);
                }
            }
            rs= pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
    //執行非查詢語句
    public int executeNonQuery(String sql,Object... args){
        int r=0;
        PreparedStatement pstmt=null;
        try {
            pstmt=conn.prepareStatement(sql);
            //把參數綁定到表達式對象
            if (args!=null){
                int i=1;
                for (Object arg:args){
                    pstmt.setObject(i++,arg);

                }
            }
           r= pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(null,pstmt,null);
        }
        return r;
    }
}
