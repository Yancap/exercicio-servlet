package br.com.ibm.controllers;

import br.com.ibm.dto.LoginRequestDTO;
import br.com.ibm.models.Database;
import br.com.ibm.utils.ErrorFactory;

import br.com.ibm.utils.ResponseFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "AuthController", urlPatterns = {"/profile", "/profile/"} )
public class AuthController extends HttpServlet {
  private PrintWriter out;
  private Database database = Database.getInstance();
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws IOException,
          ServletException
  {

    out = response.getWriter();
    String stringJSON = request.getReader().lines().collect(Collectors.joining());
    System.out.println(stringJSON);
    ObjectMapper mapper = new ObjectMapper();
    LoginRequestDTO body = mapper.readValue(stringJSON, LoginRequestDTO.class);

    try {
      var user = database.users.findByEmailAndPassword(body.getEmail(), body.getPassword());
      ResponseFactory resp = new ResponseFactory(200, "success", user);
      response.setStatus(200);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      out.print(mapper.writeValueAsString(resp));
      out.flush();
    } catch (Exception e) {
      ErrorFactory error = new ErrorFactory(401, "Invalid credentials", "WrongLoginParams");
      response.setStatus(401);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      out.print(mapper.writeValueAsString(error));
      out.flush();
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    String name = "";
    String email = "";

    var listOfCookies = Arrays.stream(request.getCookies()).toList();
    for(var cookie : listOfCookies) {
      if(cookie.getName().equals("name")) {
        name = cookie.getValue().replaceAll("_", " ");
      } else if(cookie.getName().equals("email")) {
        email = cookie.getValue();
      }
    }
    Map<String, String> items = new HashMap<>();
    items.put("name", name);
    items.put("email", email);

    request.setAttribute("items", items);
    RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
    dispatcher.forward(request, response);
  }
}
