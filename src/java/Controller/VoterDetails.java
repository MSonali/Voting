/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Model.VoterDetailsModel;
import java.io.IOException;
import java.io.PrintWriter;
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
public class VoterDetails extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String ano = request.getParameter("ano");//aadharNumber
            String password = request.getParameter("pwd");

            VoterDetailsModel details = new VoterDetailsModel();
            details.setAno(ano);
            details.setPassword(password);

            details = UserDao.vdDB(details);

            if (details.isValid()) {
                if (details.getStatus()) {
                    int uid = details.getUid();
                    HttpSession session = request.getSession();
                    session.setAttribute("uid", uid);
                    response.sendRedirect("voterdetails.jsp");
                    out.println(uid);
                } else {
                    out.print("<!DOCTYPE HTML>");
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<h1 style='color:red' align='center'>Already voted!</h1>");
                    out.print("</h1>");
                    out.print("</body>");
                    out.print("</html>");
                    RequestDispatcher rd = request.getRequestDispatcher("voterdetails.jsp");
                    rd.include(request, response);
                }
            }
            else{
                out.println("<h1 align='center' style='color:red'>Invalid Password or Aadhar Number</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("voterdetails.jsp");
                rd.include(request, response);
            }
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
