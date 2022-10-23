/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarDAO;
import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class ManageOrderForAdminController extends HttpServlet {

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
            out.println("<title>Servlet ManageOrderForAdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageOrderForAdminController at " + request.getContextPath() + "</h1>");
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
        OrderDAO odb = new OrderDAO();
        if (request.getParameter("action").equalsIgnoreCase("edit")) {
            request.setAttribute("order", odb.getOrderById(Integer.parseInt(request.getParameter("orderId"))));
            request.getRequestDispatcher("/pages/editOrder.jsp").forward(request, response);
        }
        if (request.getParameter("action").equalsIgnoreCase("delete")) {
            odb.delete(Integer.parseInt(request.getParameter("orderId")));
            if (request.getParameter("page").equalsIgnoreCase("booked")) {
                request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/pages/history.jsp").forward(request, response);
            }
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
        if (request.getParameter("action").equalsIgnoreCase("save")) {
            CarDAO cdb = new CarDAO();
            OrderDAO odb = new OrderDAO();
            HttpSession session = request.getSession(true);
            Account a = (Account) session.getAttribute("user");
            Order o = odb.getOrderById(Integer.parseInt(request.getParameter("orderId")));
            Date pickupDate = Date.valueOf(request.getParameter("pickupDate"));
            Date dropoffDate = Date.valueOf(request.getParameter("dropoffDate"));
            String status = request.getParameter("status");
            Order order = new Order(o.getId(),
                    a.getUsername(),
                    o.getCar(),
                    request.getParameter("rFullname"),
                    request.getParameter("rEmail"),
                    request.getParameter("rAddress"),
                    request.getParameter("rCity"),
                    Integer.parseInt(request.getParameter("rPhone")),
                    request.getParameter("pickupAddress"),
                    request.getParameter("dropoffAddress"),
                    pickupDate, dropoffDate,
                    Double.parseDouble(request.getParameter("total")),
                    status);
            odb.updateOrder(order);
            request.setAttribute("order", odb.getOrderById(o.getId()));
            request.getRequestDispatcher("/pages/editOrder.jsp").forward(request, response);
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
