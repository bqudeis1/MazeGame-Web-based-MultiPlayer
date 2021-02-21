package com.example.WNA_MazeGame_Online;

import baha.Maze;
import common.StringOutputFormatter;
import commands.state_pattern.CommandExecutor;

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
        Cookie[] cookies=request.getCookies();
        if(cookies.length==3){
            int gameId=Integer.parseInt(cookies[2].getValue());
            int playerId=Integer.parseInt(cookies[0].getValue());
            String commandName=request.getParameter("command");
            String commandResult=register.gamePool.processCommand(gameId,playerId,commandName);
            System.out.println(commandResult);
            response.getWriter().print(commandResult);

        }
    }
}
