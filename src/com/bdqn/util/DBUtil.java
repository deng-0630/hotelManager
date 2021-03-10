package com.bdqn.util;

import java.sql.*;

//数据库工具类
public class DBUtil {
    private static final String URL=ConfigManager.getProperty("url");
    private static final String DRIVER=ConfigManager.getProperty("driver");
    private static final String UNAME=ConfigManager.getProperty("uname");
    private static final String PWD=ConfigManager.getProperty("pwd");
    //註冊驅動
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //獲得鏈接對象
    public static Connection getConn(){
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(URL,UNAME,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    //關閉鏈接
    public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
        try{
            if (null!=rs){
                rs.close();
            }
            if (null!=pstmt){
                pstmt.close();
            }
            if (null!=conn){
                conn.close();
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
    }
}
