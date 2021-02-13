package com.example.WNA_MazeGame_Online;

import baha.Maze;
import baha.StringOutputFormatter;
import commands.standardPlayerCommandExecutor;
import player.Player;

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
            Maze game=register.gamePool.getGame(Integer.parseInt(cookies[2].getValue()));

            standardPlayerCommandExecutor standardPlayerCommand= new standardPlayerCommandExecutor(
                    game.getPlayer(Integer.parseInt(cookies[0].getValue())));
            standardPlayerCommand.processCommand(request.getParameter("command"));
            //mange to save standardPlayerCommand somewhere
        }
    }
}
