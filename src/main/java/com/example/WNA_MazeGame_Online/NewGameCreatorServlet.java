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
        boolean createGameRequest = request.getParameter("createGame") != null;
        boolean JoinGameRequest = request.getParameter("JoinGame") != null;
        String playerName = request.getParameter("name");
        int gameCode = request.getParameter("GameCode").equals("") ? -1 : Integer.parseInt(request.getParameter("GameCode"));

        Player player = null;
        if (isAcceptable(playerName)) {
            if (createGameRequest) {
                player = gamePool.registerPlayerInNewGame(playerName);
            } else if(JoinGameRequest){
                player = gamePool.registerPlayerInRandomGame(playerName);
            }else if(gameCode!=-1){
                player=gamePool.registerPlayerInGame(playerName,gameCode);
            }

            request.setAttribute("player", player);
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }

        System.out.println(request.getParameter("fName"));

        response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.setHeader("Location", request.getContextPath() + "/index.jsp");

    }

    private boolean isAcceptable(String playerName) {
        return playerName != null && !playerName.isEmpty();
    }
}
