/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class ManageProfileController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageProfileController at " + request.getContextPath() + "</h1>");
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
        try {
            PrintWriter out = response.getWriter();
            AccountDAO db = new AccountDAO();
            HttpSession session = request.getSession(true);
            Account account = (Account) session.getAttribute("user");
            String newFullName = request.getParameter("newFullName");
            String newAddress = request.getParameter("newAddress");
            String newCity = request.getParameter("newCity");
            int newPhone = Integer.parseInt(request.getParameter("newPhone"));
            String newEmail = request.getParameter("newEmail");
            String old_password = getMd5(request.getParameter("oldPassword"));
            String new_password = getMd5(request.getParameter("newPassword"));
            String renew_password = getMd5(request.getParameter("reNewPassword"));
            String changePassword = request.getParameter("changePassword");
            if (db.existedEmail(newEmail, account.getUsername(), 2)) {
                request.setAttribute("error", "Email address already exists!");
                request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
            }
            if (db.existedPhone(newPhone, account.getUsername(), 2)) {
                request.setAttribute("error", "Phone number already exists!");
                request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
            }
            if (changePassword != null) {
                if (!old_password.equals(account.getPassword())) {
                    request.setAttribute("error", "Password incorrect!");
                    request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                }
                if (!renew_password.equals(new_password)) {
                    request.setAttribute("error", "New password does not match!");
                    request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                }
                if (!(old_password.equals(account.getPassword()) && renew_password.equals(new_password))) {
                    new_password = account.getPassword();
                }
            } else {
                new_password = account.getPassword();
            }
            account.setFullname(newFullName);
            account.setEmail(newEmail);
            account.setAddress(newAddress);
            account.setCity(newCity);
            account.setPhone(newPhone);
            account.setPassword(new_password);
            db.updateAccount(new Account(account.getUsername(), new_password, account.getType(), newFullName, newEmail, newAddress, newCity, newPhone));
            request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManageProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
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
