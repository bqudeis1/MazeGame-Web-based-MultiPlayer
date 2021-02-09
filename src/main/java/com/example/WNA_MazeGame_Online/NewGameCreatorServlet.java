package com.example.WNA_MazeGame_Online;

import baha.GamesPool;
import baha.Maze;
import baha.MazeGame;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "newGameCreatorServlet", value = "/newGameCreatorServlet")
public class NewGameCreatorServlet extends HttpServlet {
  public static GamesPool gamePool = new GamesPool();

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    boolean newGameState = request.getParameter("newGame") != null;
    // boolean newGame= request.getParameter("newGame");
    if (newGameState) {
      Maze maze = new MazeGame().CreateMaze();
      gamePool.addGame(maze);
      Cookie gameId = new Cookie("GameId", maze.getGameId() + "");
      response.addCookie(gameId);
    }else{


    }
    System.out.println(request.getParameter("fName"));

    // response.sendRedirect(request.getContextPath() + "/index.jsp");
    response.setHeader("Location", request.getContextPath() + "/index.jsp");
  }
}
