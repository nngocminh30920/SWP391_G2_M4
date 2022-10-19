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
public class ManageProdileForAdmin extends HttpServlet {

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
            out.println("<title>Servlet ManageProdileForAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageProdileForAdmin at " + request.getContextPath() + "</h1>");
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
        AccountDAO adb = new AccountDAO();
        HttpSession session = request.getSession(true);
        Account account = (Account) session.getAttribute("user");
        if (request.getParameter("action").equalsIgnoreCase("view")) {
            request.setAttribute("listAccount", adb.getAllAcountExceptType(3));
            request.getRequestDispatcher("/pages/manageProfile.jsp").forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("edit")) {
            request.setAttribute("account", adb.getAcountById(request.getParameter("username")));
            request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            adb.delete(request.getParameter("username"));
            request.setAttribute("listAccount", adb.getAllAcountExceptType(3));
            request.getRequestDispatcher("/pages/manageProfile.jsp").forward(request, response);
        }

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
        AccountDAO adb = new AccountDAO();
        HttpSession session = request.getSession(true);
        Account account = (Account) session.getAttribute("user");
        if (request.getParameter("action").equalsIgnoreCase("save")) {
            try {
                String username = request.getParameter("username");
                String newFullName = request.getParameter("newFullName");
                String newAddress = request.getParameter("newAddress");
                String newCity = request.getParameter("newCity");
                int newPhone = Integer.parseInt(request.getParameter("newPhone"));
                String newEmail = request.getParameter("newEmail");
                String old_password = getMd5(request.getParameter("oldPassword"));
                String new_password = getMd5(request.getParameter("newPassword"));
                String renew_password = getMd5(request.getParameter("reNewPassword"));
                String changePassword = request.getParameter("changePassword");
                int type = Integer.parseInt(request.getParameter("type"));
                if (adb.existedEmail(newEmail, username, 2)) {
                    request.setAttribute("error", "Email address already exists!");
                    request.setAttribute("account", adb.getAcountById(username));
                    request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                }
                if (adb.existedPhone(newPhone, username, 2)) {
                    request.setAttribute("error", "Phone number already exists!");
                    request.setAttribute("account", adb.getAcountById(username));
                    request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                }
                if (changePassword != null) {
                    if (!old_password.equals(account.getPassword())) {
                        request.setAttribute("error", "Password incorrect!");
                        request.setAttribute("account", adb.getAcountById(username));
                        request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                    }
                    if (!renew_password.equals(new_password)) {
                        request.setAttribute("error", "New password does not match!");
                        request.setAttribute("account", adb.getAcountById(username));
                        request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
                    }
                    if (!(old_password.equals(adb.getAcountById(username).getPassword()) && renew_password.equals(new_password))) {
                        new_password = adb.getAcountById(username).getPassword();
                    }
                } else {
                    new_password = adb.getAcountById(username).getPassword();
                }
                account.setFullname(newFullName);
                account.setEmail(newEmail);
                account.setAddress(newAddress);
                account.setCity(newCity);
                account.setPhone(newPhone);
                account.setPassword(new_password);
                adb.updateAccount(new Account(username, new_password, type, newFullName, newEmail, newAddress, newCity, newPhone));
                request.setAttribute("account", adb.getAcountById(username));
                request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ManageProdileForAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
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
