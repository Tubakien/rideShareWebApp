package com.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Created by student on 3/22/17.
 */
@WebServlet(
        name = "profilePage",
        urlPatterns = {"/myprofile"}
) public class ProfilePageServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int sessionCounter;

        Integer sessionCountInteger;
        sessionCountInteger = (Integer) session.getAttribute("sessionCounter");

        if (sessionCountInteger == null) {
            sessionCounter = 1;
        } else {
            sessionCounter = sessionCountInteger;
            sessionCounter++;
        }

        session.setAttribute("sessionCounter", sessionCounter);

        // Create the url
        String url = "/myProfile.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
