package com.example.WNA_MazeGame_Online;

import common.StringOutputFormatter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@WebServlet(name = "CommandExecutorServlet", value = "/CommandExecutorServlet")
public class CommandExecutorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("command"));
        //response.getWriter().print(StringOutputFormatter.getResultInAppropriateFormat(request.getParameter("command")));
        Cookie[] cookies = request.getCookies();
        HashMap<String, Cookie> cookieHashSet = new HashMap<>();
        for (Cookie cookie : cookies) {
            cookieHashSet.put(cookie.getName(), cookie);
        }

            int gameId = Integer.parseInt(cookieHashSet.get("gameId").getValue());
            int playerId = Integer.parseInt(cookieHashSet.get("playerId").getValue());
            String commandName = request.getParameter("command");
            String commandResult = register.gamePool.processCommand(gameId, playerId, commandName);
            System.out.println(commandResult);
            response.getWriter().print(commandResult);

        }
    }

