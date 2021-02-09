package com.example.WNA_MazeGame_Online;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
  private String message;

  public void init() {
    // message = "Hello World!";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    PrintWriter out = response.getWriter();
    Date currentTime = new Date();
    String message = String.format("get Currently time is %tr on %tD.", currentTime, currentTime);
    out.print(message);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
    // new Player(){create game or enter a game,the player should send his name,add
    // cockes}->redirect.

    // old Player ->send normal command{commands}
    //
    // Create new game.
    //
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    PrintWriter out = response.getWriter();
    Date currentTime = new Date();
    String message =
        String.format(
            "post Currently time is %tr on %tD." + req.getParameter("para1"),
            currentTime,
            currentTime);
    out.print(message);
  }

  public void destroy() {}
}
