/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Model.SMS;
import Model.VoteNowModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sonali
 */
public class VoteNow extends HttpServlet {
     SMS sms = new SMS();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public String candi_nom;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            candi_nom = request.getParameter("candirad");
            HttpSession session = request.getSession();
            session.setAttribute(candi_nom, candi_nom);
            System.out.println(candi_nom);
            String aadhar = (String) session.getAttribute("aadhar");
            System.out.println("aadhar: "+aadhar);
            
            VoteNowModel vote = new VoteNowModel();
            vote.setCandiname(candi_nom);
            vote.setAno(aadhar);
            vote = UserDao.vnDB(vote);

            if (vote.isValid()&&vote.getVoterUp()) {
                out.println("<h1 align='center' style='color:green'>Success </h1>");
                sms.sendSms(candi_nom);
                RequestDispatcher rd = request.getRequestDispatcher("Exit.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h1 align='center' style='color:red'>Updation failed</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("Exit.jsp");
                rd.forward(request, response);

            }
            /*if (vote.getVoterUp()) {
                out.println("<h1 align='center' style='color:green'>Voter updated</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("Exit.jsp");
                rd.forward(request, response);
            } else {
                out.println("<h1 align='center' style='color:red'>Voting failed</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("Exit.jsp");
                rd.include(request, response);
            }*/
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
        processRequest(request, response);
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
