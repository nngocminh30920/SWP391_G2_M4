/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarDAO;
import dao.ImageDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Account;
import model.Car;
import model.Image;

/**
 * this class contain post method for add car function 
 * @author Cao Hong Phuc
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AddCarController extends HttpServlet {

    public static final String SAVE_DIRECTORY = "assets/image";

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
            out.println("<title>Servlet AddCarController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCarController at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        if (session.getAttribute("user") == null) {
            request.setAttribute("error", "UNAUTHORIZED!");
            request.setAttribute("mess", "Sign in to jobber account");
            request.setAttribute("href", "../../Demo/pages/login.jsp");
            request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
        }
        String owner = account.getUsername();
        if (account.getType() == 3) {
            owner = request.getParameter("owner");
        }
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String type = request.getParameter("type");
        String tranmission = request.getParameter("tranmission");
        int seat = Integer.parseInt(request.getParameter("seat"));
        int door = Integer.parseInt(request.getParameter("door"));
        double price = Double.parseDouble(request.getParameter("price"));
        String overview = request.getParameter("overview").trim().isEmpty() ? "None" : request.getParameter("overview");
        String description = request.getParameter("description").trim().isEmpty() ? "None" : request.getParameter("description");
        String view = overview + " /" + description;
        String fileName;
        try {
            // Đường dẫn tuyệt đối tới thư mục gốc của web app.
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String appPathRoot = appPath.substring(0, appPath.indexOf("build")) + "web/";

            // Thư mục để save file tải lên.
            String fullSavePath;
            String fullSavePathRoot;
            if (appPath.endsWith("/")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "/" + SAVE_DIRECTORY;
            }

            if (appPathRoot.endsWith("/")) {
                fullSavePathRoot = appPathRoot + SAVE_DIRECTORY;
            } else {
                fullSavePathRoot = appPathRoot + "/" + SAVE_DIRECTORY;
            }

            // Tạo thư mục nếu nó không tồn tại.
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            File fileSaveDirRoot = new File(fullSavePathRoot);
            if (!fileSaveDirRoot.exists()) {
                fileSaveDirRoot.mkdir();
            }

            String filePath;
            String filePathRoot;
            int i = 0;
            List<String> listFileName = new ArrayList<>();
            for (Part part : request.getParts()) {
                //Danh mục các phần đã upload lên(Có thể là nhiều file).
                fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    filePath = fullSavePath + File.separator + owner.replaceAll("\\s+", "") + i + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                    listFileName.add(owner.replaceAll("\\s+", "") + (i) + brand + model + fileName.substring(fileName.lastIndexOf('.')));
                    i++;
                    // Ghi vào file.
                    part.write(filePath);
                }
            }
            i = 0;
            for (Part part : request.getParts()) {
                fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    filePathRoot = fullSavePathRoot + File.separator + owner.replaceAll("\\s+", "") + i + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                    i++;
                    part.write(filePathRoot);
                }
            }
            CarDAO db = new CarDAO();
            ImageDAO idb = new ImageDAO();
            db.insert(new Car(0, owner, brand, model, type, tranmission, seat, door, price, listFileName.get(0), view));
            List<Car> listCar = db.getCarForOwner(owner);
            int carid = listCar.get(listCar.size() - 1).getId();
            for (int j = 1; j < listFileName.size(); j++) {
                idb.insert(new Image(1, carid, listFileName.get(j)));
            }
            request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
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
