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
import java.util.ArrayList;
import model.Chapter;
import model.Exercises;
import model.ListBook;
import model.Page;

/**
 *
 * @author MSII
 */
@WebServlet(name="Answer", urlPatterns={"/answer"})
public class Answer extends HttpServlet {
   
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
            out.println("<title>Servlet Answer</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Answer at " + request.getContextPath () + "</h1>");
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
        DAO dao = new DAO();
        int ExID = Integer.parseInt(request.getParameter("id")) ;
        model.Answer a = dao.getAnswerByExID(ExID);
        request.setAttribute("a", a);
        String isbn = request.getParameter("isbn");
        Exercises e = dao.getExercisesByExID(ExID);
        request.setAttribute("e", e);
        int cid = Integer.parseInt(request.getParameter("cid"));
        Chapter c = dao.getChapterByChapterID(cid);
        request.setAttribute("c", c);
        Page p = dao.getPageByPageID(cid);
        request.setAttribute("p", p);
        ListBook b = dao.getBookByIsbn(isbn);
        request.setAttribute("b", b);
        ArrayList<model.Answer> la= dao.getAllAnswerByExID(ExID);
        request.setAttribute("la", la);
        
        
        request.getRequestDispatcher("exercises.jsp").forward(request, response);
         
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
