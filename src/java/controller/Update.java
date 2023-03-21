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
import model.StudySet;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "Update", urlPatterns = {"/update"})
public class Update extends HttpServlet {

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
            out.println("<title>Servlet Update</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
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
    int id;
    int num_root;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        id = Integer.parseInt(id_raw);
        DAO d = new DAO();
        StudySet set = d.getStudySetById(id);
        request.setAttribute("titleSet", set.getTitle());
        request.setAttribute("descSet", set.getDescription());
        request.setAttribute("isShare", set.isIsShare());
        request.setAttribute("id", id);
        ArrayList<Card> listC = d.getAllCardInSet(id);
        HttpSession ses = request.getSession();
        ses.setAttribute("listC", listC);
        num = listC.size();
        num_root = num;
        request.setAttribute("numCard", num);
        request.getRequestDispatcher("update.jsp").forward(request, response);
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
        ArrayList<Card> listCUpdate = new ArrayList<>();
        ArrayList<Card> listCAdd = new ArrayList<>();

        String[] listTitleCard = request.getParameterValues("card-title");
        String[] listDescCard = request.getParameterValues("card-desc");
        String[] listId = request.getParameterValues("id-card");
        for (int i = 0; i < listTitleCard.length; i++) {
            listC.add(new Card(Integer.parseInt(listId[i]), listTitleCard[i], listDescCard[i], id));
            if (i < num_root) {
                listCUpdate.add(new Card(Integer.parseInt(listId[i]), listTitleCard[i], listDescCard[i], id));
            } else {
                listCAdd.add(new Card(Integer.parseInt(listId[i]), listTitleCard[i], listDescCard[i], id));
            }
        }
        String titleSet = request.getParameter("titleSet");
        String descSet = request.getParameter("descSet");
        boolean isShare = request.getParameter("isShare") != null;

        if (btnIncrease != null) {
            num = num + 1;
            request.setAttribute("numCard", num);
            listC.add(new Card(0, "", "", 1));
            ses.setAttribute("listC", listC);
            request.setAttribute("titleSet", titleSet);
            request.setAttribute("descSet", descSet);
            request.setAttribute("isShare", isShare);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else {
            StudySet set = new StudySet(id, titleSet, descSet, isShare, 1);

            d.updateStudySet(set);
            for (Card c : listCUpdate) {
                if (!c.getTerm().equals("") || !c.getDefinition().equals("")) {
                    Card c_new = new Card(c.getId(), c.getTerm(), c.getDefinition(), d.getIdStudySet());
                    d.updateCard(c_new);
                }
            }
            for (Card c : listCAdd) {
                if (!c.getTerm().equals("") || !c.getDefinition().equals("")) {
                    Card c_new = new Card(c.getId(), c.getTerm(), c.getDefinition(), id);
                    d.addCard(c_new);
                }
            }
            response.sendRedirect("home");
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
