package com.mzik.http.servlet;

import com.mzik.http.dto.FlightDto;
import com.mzik.http.service.FlightService;
import com.mzik.http.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightDtos = flightService.findAll();
        req.setAttribute("flights", flightDtos);
        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));


        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
