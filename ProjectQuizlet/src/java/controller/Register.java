/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utility.Utilities;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String avatar = request.getParameter("avatar");
        String language = request.getParameter("lang");
        Utilities val = new Utilities();

        if (val.isBlank(email) || val.isBlank(name) || val.isBlank(email)) {
            request.setAttribute("errEmpty", "You must filled all!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (val.validInputRequire(email, name, pass) != null) {
            String notifyErr = val.validInputRequire(email, name, pass);
            request.setAttribute("errInvalidInput", notifyErr);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if(val.checkExistEmail(email)) {
            String notifyErr = "Tài khoản đã được đăng kí, vui lòng sử dụng email khác.";
            request.setAttribute("errInvalidInput", notifyErr);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            try {
                DAO d = new DAO();
                User user = new User(name, pass, email, false, avatar, 0, language);
                d.register(user);
                response.sendRedirect("login.jsp");
            } catch(Exception e) {
                System.out.println(e);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
