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
import java.util.ArrayList;
import model.Folder;
import model.StudySet;
import model.User;

/**
 *
 * @author ASUS
 */
@WebServlet(name="FolderSet", urlPatterns={"/folderSet"})
public class FolderSet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FolderSet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FolderSet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO d = new DAO();
        HttpSession ses = request.getSession();
        User user = (User)ses.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<StudySet> listSS = d.getListStudySet(id);
        Folder f = d.getFolderByFolderId(id);
        request.setAttribute("f", f);
        request.setAttribute("folderId", id);
        request.setAttribute("listSS", listSS);
        request.setAttribute("d", d);
        request.setAttribute("user", user);
        ArrayList<StudySet> listS = d.getAllStudySet();
        ses.setAttribute("listS", listS);
        request.getRequestDispatcher("folderSet.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      int folderId = Integer.parseInt(request.getParameter("folderId"));
      DAO d = new DAO();
      d.deleteFolderInListClass(folderId);
      d.removeListFolder(folderId);
      d.deleteFolderByFolderId(folderId);
      response.sendRedirect("folder");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
