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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Car;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class AuthController extends HttpServlet {

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
        CarDAO cdb = new CarDAO();
        OrderDAO odb = new OrderDAO();
        HttpSession session = request.getSession(true);
        Account a = (Account) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        if (a == null) {
            request.setAttribute("error", "UNAUTHORIZED!");
            request.setAttribute("mess", "Please sign in to do");
            request.setAttribute("href", "../../Demo/pages/login.jsp");
            request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
        } else {
            //1 - Renter
            if (a.getType() == 1) {
                String action = request.getParameter("action");
                switch (action) {
                    case "requestOrder":
                        Car car = cdb.getCarByID(Integer.parseInt(request.getParameter("carid")));
                        Date pickupDate = Date.valueOf(request.getParameter("pickupDate"));
                        Date dropoffDate = Date.valueOf(request.getParameter("dropoffDate"));
                        long days = ChronoUnit.DAYS.between(
                                LocalDate.parse(pickupDate.toString()),
                                LocalDate.parse(dropoffDate.toString()));
                        Order order = new Order(0, a.getUsername(), car,
                                request.getParameter("rFullname"),
                                request.getParameter("rEmail"),
                                request.getParameter("rAddress"),
                                request.getParameter("rCity"),
                                Integer.parseInt(request.getParameter("rPhone")),
                                request.getParameter("pickupAddress"),
                                request.getParameter("dropoffAddress"),
                                pickupDate, dropoffDate, days * car.getPrice(), "Request");
                        request.setAttribute("order", order);
                        request.getRequestDispatcher("/order").forward(request, response);
                        break;
                    case "cancel":
                        odb.updateStatus("Cancel", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "confirmReceivedCar":
                        odb.updateStatus("Inprogress", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "confirmRejectHidden":
                        odb.updateStatus("RejectHidden", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "completedOrder":
                        odb.updateStatus("Completed", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "veiwDetail":
                        Order order1 = odb.getOrderById(Integer.parseInt(request.getParameter("orderId")));
                        request.setAttribute("order", order1);
                        request.getRequestDispatcher("/pages/bookedDetail.jsp").forward(request, response);
                        break;
                    default:
                        request.setAttribute("error", "UNAUTHORIZED!");
                        request.setAttribute("mess", "Sign in to jobber account");
                        request.setAttribute("href", "../../Demo/pages/login.jsp");
                        request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
                        break;
                }
            } //2 - Jobber
            else {
                String action = request.getParameter("action");
                switch (action) {
                    case "addCar":
                        request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
                        break;
                    case "manageCar":
                        request.getRequestDispatcher("/manageCar?action=view").forward(request, response);
                        break;
                    case "editCar":
                        request.getRequestDispatcher("/manageCar?action=edit&id=" + request.getParameter("id")).forward(request, response);
                        break;
                    case "deleteCar":
                        request.getRequestDispatcher("../../Demo/manageCar?action=edit&id=" + request.getParameter("id")).forward(request, response);
                        break;
                    case "acceptOrder":
                        odb.updateStatus("Accept", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "rejectOrder":
                        odb.updateStatus("Reject", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "deliverCar":
                        odb.updateStatus("DeliverCar", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "confirmCompletedHidden":
                        odb.updateStatus("CompletedHidden", Integer.parseInt(request.getParameter("orderId")));
                        request.getRequestDispatcher("/pages/booked.jsp").forward(request, response);
                        break;
                    case "veiwDetail":
                        Order order = odb.getOrderById(Integer.parseInt(request.getParameter("orderId")));
                        request.setAttribute("order", order);
                        request.getRequestDispatcher("/pages/bookedDetail.jsp").forward(request, response);
                        break;
                    default:
                        request.setAttribute("error", "UNAUTHORIZED!");
                        request.setAttribute("mess", "Sign in to renter account");
                        request.setAttribute("href", "../../Demo/pages/login.jsp");
                        request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
                        break;
                }
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
