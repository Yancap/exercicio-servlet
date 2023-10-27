package br.com.ibm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExemploServlet", urlPatterns = {"/exemplo"})
public class ExemploServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        List<String> items = new ArrayList<>();
        items.add("item 1");
        items.add("item 2");
        items.add("item 3");
        items.add("item 4");

        request.setAttribute("items", items);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/exemplo.jsp");
        dispatcher.forward(request, response);
    }
}