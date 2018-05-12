/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.UserDao;
import Model.CheckModel;
import Model.VoteNowModel;
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
public class Check extends HttpServlet {

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
            String ano = request.getParameter("ano");
            int uid = Integer.parseInt(request.getParameter("uid"));
            HttpSession session = request.getSession();
            
            session.setAttribute("aadhar", ano);
            CheckModel check = new CheckModel();
            check.setAno(ano);
            check.setUid(uid);
            System.out.println("calling chkdb...");
            check = UserDao.chkDB(check);

            if (check.isValid()) {
                System.out.println("Verification Successfull...");
                String location = check.getLocation();
                if (location.equals("anna nagar")) {
                    RequestDispatcher rd = request.getRequestDispatcher("votenow.jsp");
                    rd.forward(request, response);
                }
                if (location.equalsIgnoreCase("villivakkam")) {
                    RequestDispatcher rd = request.getRequestDispatcher("votenow_villivakkam.jsp");
                    rd.forward(request, response);

                }
                if (location.equalsIgnoreCase("RKNagar")) {
                    RequestDispatcher rd = request.getRequestDispatcher("votenow_rknagar.jsp");
                    rd.forward(request, response);
                }
            } else {
                out.println("<h1 align='center' style='color:red'> Invalid aadhar no. or uid </h1>");
                RequestDispatcher rd = request.getRequestDispatcher("check.jsp");
                rd.include(request, response);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Check</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Check at " + request.getContextPath() + "</h1>");
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
