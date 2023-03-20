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
import model.Card;
import model.Folder;
import model.StudySet;
import model.User;
import utility.Utilities;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "FlashCards", urlPatterns = {"/flashCards"})
public class FlashCards extends HttpServlet {

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
            out.println("<title>Servlet FlashCards</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FlashCards at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        DAO d = new DAO();
        StudySet set = d.getStudySetById(id);
        User author = d.getUserByUserId(set.getUserId());
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<Card> listC = d.getAllCardInSet(id);
        Utilities u = new Utilities();
        boolean isShare = true;
        if (!set.isIsShare() && set.getUserId() != user.getId()) {
            isShare = false;
        }
        if (user != null) {
            ArrayList<Integer> listId = d.getListStudiedCardId(set.getId(), user.getId());
            ArrayList<Folder> listFl = d.getAllFolderByUserId(user.getId());
            request.setAttribute("listFl", listFl);
            ArrayList<model.Class> listClass = d.getClassByUserId(user.getId());
            request.setAttribute("listClass", listClass);
            ArrayList<Card> listCSL = d.getCardStillLearning(id, user.getId());
            ArrayList<Card> listUL = d.getCardUnlearning(id, user.getId());
            ArrayList<Card> listCM = d.getCardMastered(id, user.getId());
            request.setAttribute("listCM", listCM);
            request.setAttribute("listCSL", listCSL);
            request.setAttribute("listUL", listUL);
        }
        request.setAttribute("isShare", isShare);
        request.setAttribute("id", id);
        request.setAttribute("u", u);
        request.setAttribute("set", set);
        request.setAttribute("listC", listC);
        request.setAttribute("author", author);
        request.setAttribute("user", user);
//        request.setAttribute("currentNumCard", listId.size());
        request.getRequestDispatcher("flashCards.jsp").forward(request, response);
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
