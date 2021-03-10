package com.bdqn.servlet;

import com.bdqn.entity.Room;
import com.bdqn.service.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        Room room=new Room();
        try {
            room.setRoomNo(Integer.parseInt(request.getParameter("roomNo")));
            room.setRoomType(request.getParameter("roomType"));
            room.setPeopleConut(Integer.parseInt(request.getParameter("peopleCount")));
            room.setRent(Float.parseFloat(request.getParameter("rent")));
            room.setIsRental(0);
            room.setCreateTime(new Date());
            room.setUpdatedTime(new Date());
            int r=new RoomServiceImpl().addRoom(room);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script>");
            if (r>0){
                out.print("alert(\"添加成功\");");
                out.print("location.href=\"home\";");
            }else {
                out.print("alert(\"添加失败\");");
            }
            out.print("</script>");
            out.flush();
            out.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
