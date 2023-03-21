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
import model.Card;
import model.ListFolder;
import model.ListStudySet;
import model.StudySet;
import model.User;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CreateSet", urlPatterns = {"/createSet"})
public class CreateSet extends HttpServlet {

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
            out.println("<title>Servlet CreateSet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateSet at " + request.getContextPath() + "</h1>");
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
    int num;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        num = 5;
        ArrayList<Card> listC = new ArrayList<>();
        request.setAttribute("numberCard", num);
        for (int i = 0; i < num; i++) {
            Card c = new Card(0, "", "", 1);
            listC.add(c);
        }
        request.getSession().setAttribute("listC", listC);
        try {

            int folderId = Integer.parseInt(request.getParameter("folderId"));
            request.getSession().setAttribute("folderId", folderId);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int classId = Integer.parseInt(request.getParameter("classId"));
            request.getSession().setAttribute("classId", classId);
        } catch (Exception e) {
            System.out.println(e);
        }

        request.setAttribute("isShare", true);

        request.getRequestDispatcher("createSet.jsp").forward(request, response);
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
        HttpSession ses = request.getSession();
        String btnIncrease = request.getParameter("btn-increase");
        DAO d = new DAO();
        ArrayList<Card> listC = new ArrayList<>();
        int folderId = 0;

        try {
            folderId = (int) ses.getAttribute("folderId");
        } catch (Exception e) {
            System.out.println(e);
        }
        int classId = 0;
        try {
            classId = (int) ses.getAttribute("classId");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(classId);

        String[] listTitleCard = request.getParameterValues("card-title");
        String[] listDescCard = request.getParameterValues("card-desc");
        for (int i = 0; i < listTitleCard.length; i++) {
            listC.add(new Card(0, listTitleCard[i], listDescCard[i], 0));
        }
        String titleSet = request.getParameter("titleSet");
        boolean isShare = request.getParameter("isShare") != null;
        String descSet = request.getParameter("descSet");

        if (btnIncrease != null) {
            num = num + 1;
            request.setAttribute("numberCard", num);
            listC.add(new Card(0, "", "", 1));
            ses.setAttribute("listC", listC);
            request.setAttribute("titleSet", titleSet);
            request.setAttribute("descSet", descSet);
            request.getRequestDispatcher("createSet.jsp").forward(request, response);
        } else {
            int countCard = 0;
            for (Card c : listC) {
                if (!c.getTerm().equals("") || !c.getDefinition().equals("")) {
                    countCard++;
                }
            }
            if (countCard < 2) {
                request.setAttribute("numberCard", num);
                ses.setAttribute("listC", listC);
                request.setAttribute("titleSet", titleSet);
                request.setAttribute("descSet", descSet);
                request.setAttribute("err_card", "Bạn cần thêm 2 thẻ để tạo 1 học phần.");
                request.getRequestDispatcher("createSet.jsp").forward(request, response);
            } else {
                User user = (User) ses.getAttribute("user");
                StudySet set = new StudySet(0, titleSet, descSet, isShare, user.getId());
                d.addStudySet(set);
                for (Card c : listC) {
                    if (!c.getTerm().equals("") || !c.getDefinition().equals("")) {
                        Card c_new = new Card(0, c.getTerm(), c.getDefinition(), d.getIdStudySet());
                        d.addCard(c_new);
                    }
                }

                if (folderId != 0) {
                    ListFolder ListF = new ListFolder(d.getIdStudySet(), folderId, 10);
                    d.createListFolder(ListF);
                    ses.setAttribute("folderId", "");
                }
                 if (classId != 0) {
                      ListStudySet ListC = new ListStudySet(classId, d.getIdStudySet() , 10);
                    d.createListClass(ListC);
                    ses.setAttribute("classId", "");
                }
                response.sendRedirect("home");
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
