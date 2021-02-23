package com.example.WNA_MazeGame_Online;

import baha.Maze;
import com.google.gson.Gson;
import gameContext.GameStatus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookie = request.getCookies();
        //response when game start.
        int gameId = Integer.parseInt(cookie[2].getValue());
        Maze maze = register.gamePool.getGame(gameId);
        GameStatus gameStatus = maze.getGameStatus();

        String json = new Gson().toJson(gameStatus);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }



}
