package com.example.WNA_MazeGame_Online;

import baha.StringOutputFormatter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CommandExecutorServlet", value = "/CommandExecutorServlet")
public class CommandExecutorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("command"));
        response.getWriter().print(StringOutputFormatter.getResultInAppropriateFormat(request.getParameter("command")));
    }
}
