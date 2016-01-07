/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ipc2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ReimerGhost <rchamale10@gmail.com>
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/Sesiones"})
public class NewServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        HttpSession session = request.getSession(true);
        Integer accesos = (Integer)session.getAttribute("accesos");
 
        if (accesos == null) {
            accesos = new Integer(1);
        } else {
            accesos = new Integer(accesos.intValue() + 1);
        }
 
        session.setAttribute("accesos", accesos);
 
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletSession</title>");
            out.println("</head>");
            out.println("<body>");
 
            Integer numeroAccesos = (Integer)session.getAttribute("accesos");
 
            out.println("<p>Numero de accesos: " + numeroAccesos + "</p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
