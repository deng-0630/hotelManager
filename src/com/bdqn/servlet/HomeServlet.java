package com.bdqn.servlet;

import com.bdqn.entity.Room;
import com.bdqn.service.RoomService;
import com.bdqn.service.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Room> r=new RoomServiceImpl().getAll();
        request.setAttribute("room",r);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
