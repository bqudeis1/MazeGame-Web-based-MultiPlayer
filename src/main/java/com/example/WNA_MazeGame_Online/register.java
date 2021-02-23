package com.example.WNA_MazeGame_Online;

import baha.GamesPool;
import player.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Observable;

@WebServlet(name = "register", value = "/register")
public class register extends HttpServlet {
    public static GamesPool gamePool = new GamesPool();//this location need to change and this may use singletoon

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //response when the game start
        //while (){
        //gamePool.getGame(12).getGameStatus().isGameStart();
        //wait(1000);
        //}
        //response game started

        //gameFinish
        //wait(time duration/2)
        //response


        //getGameStatus

        //when gameStatusGange
        //respose































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

            Cookie playerId = new Cookie("playerId", player.getId() + "");
            Cookie gameId = new Cookie("gameId", player.getGameId() + "");
            response.addCookie(playerId);
            response.addCookie(gameId);
            request.setAttribute("player", player);
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
    }

    private boolean isAcceptable(String playerName) {
        return playerName != null && !playerName.isEmpty();
    }
}
