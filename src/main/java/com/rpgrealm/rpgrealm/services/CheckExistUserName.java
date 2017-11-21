package com.rpgrealm.rpgrealm.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.rpgrealm.rpgrealm.models.User;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "controllers.CheckExistUserName", urlPatterns = "/exists")
public class CheckExistUserName extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("application/json");
    String username = request.getParameter("username");
    /*User ifExists = DaoFactory.getUsersDao().findByUsername(username);
    Integer existence;

    if (ifExists != null){
      existence = 1;
    }
    else{ existence = 0;}

    JSONObject obj = new JSONObject();
    try {
      obj.put("exists", existence);
    } catch (JSONException e) {
      e.printStackTrace();
    }

    //TESTING STUFF BELOW
    System.out.println("ifExists contains: " + ifExists);
    System.out.println("username parameter = " + username);
    System.out.println(existence);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(String.valueOf(obj));
*/
  }
}
