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

/**
 *
 * @author vieta
 */
@WebServlet(name = "ControllerClassSet", urlPatterns = {"/controllerClassSet"})
public class ControllerClassSet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerClassSet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerClassSet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int studySetId = -1;
        try {
             studySetId = Integer.parseInt(request.getParameter("studySetId"));
        } catch(Exception e) {
            System.out.println(e);
        }
        int folderId = -1;
        try {
            folderId = Integer.parseInt(request.getParameter("folderId"));
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("folderId: " + folderId);
        int classId = Integer.parseInt(request.getParameter("classId"));
        String method = request.getParameter("method");
        DAO d = new DAO();
        if (folderId == -1) {
            if (method.equals("delete")) {
                d.deleteStudySetInClass(classId, studySetId);
            } else if (method.equals("add")) {
                d.addStudySetInClass(classId, studySetId);
            }
        } else {
            if(method.equals("delete")) {
                d.deleteFolderInClass(classId, folderId);
            } else if(method.equals("add")) {
                d.addFolderInClass(classId, folderId);
            }
        }
        response.sendRedirect("classSet?id=" + classId);
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
        processRequest(request, response);
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
