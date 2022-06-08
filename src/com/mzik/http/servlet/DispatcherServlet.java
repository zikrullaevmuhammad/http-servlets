package com.mzik.http.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var requestDispatcher = req.getRequestDispatcher("/flights");
//
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        var printWriter = resp.getWriter();
//        printWriter.write("Hello 2");
//
//        requestDispatcher.include(req, resp);

//        getServletContext().getRequestDispatcher()

//        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);

        resp.sendRedirect("/flights");
    }
}
