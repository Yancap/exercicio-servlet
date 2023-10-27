package br.com.ibm.controllers;

import br.com.ibm.dto.LoginRequestDTO;
import br.com.ibm.utils.ErrorFactory;

import br.com.ibm.utils.ResponseFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "AuthController", urlPatterns = {"/profile"} )
public class AuthController extends HttpServlet {
  private PrintWriter out;
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

    if(body.getEmail().equals("yan@email.com") && body.getPassword().equals("12345")) {
      //var bodyResponse = mapper.writeValueAsString(body);
      ResponseFactory resp = new ResponseFactory(200, "success", body);
      response.setStatus(200);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      out.print(mapper.writeValueAsString(resp));
      out.flush();
    } else {
      ErrorFactory error = new ErrorFactory(401, "Invalid credentials", "WrongLoginParams");
      response.setStatus(401);
      response.setCharacterEncoding("UTF-8");
      response.setContentType("application/json");
      out.print(mapper.writeValueAsString(error));
      out.flush();
    }
  }
}
