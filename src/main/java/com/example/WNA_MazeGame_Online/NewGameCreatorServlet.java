package com.example.WNA_MazeGame_Online;

import baha.GamesPool;
import player.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "newGameCreatorServlet", value = "/newGameCreatorServlet")
public class NewGameCreatorServlet extends HttpServlet {
    public static GamesPool gamePool = new GamesPool();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String playerName = request.getParameter("name");
        Player player = null;

        if (isAcceptable(playerName)) {
            String joinGameRequest = request.getParameter("joinGameRequest");

            switch (joinGameRequest) {
                case "createGame":
                    player = gamePool.registerPlayerInNewGame(playerName);
                    break;
                case "findGame":
                    player = gamePool.registerPlayerInRandomGame(playerName);
                    break;
                case "enterCode":
                    int gameCode = request.getParameter("gameCode").equals("") ? -1 :
                        Integer.parseInt(request.getParameter("gameCode"));
                    if (gameCode != -1) {
                        player = gamePool.registerPlayerInGame(playerName, gameCode);
                        break;
                    }
            }
            request.setAttribute("player", player);
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
//        System.out.println(request.getParameter("fName"));
//
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
//        response.setHeader("Location", request.getContextPath() + "/index.jsp");

        }
    }

    private boolean isAcceptable(String playerName) {
        return playerName != null && !playerName.isEmpty();
    }
}
