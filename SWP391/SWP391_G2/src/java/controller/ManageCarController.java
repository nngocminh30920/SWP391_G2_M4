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
 *
 * @author ADMIN
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB

public class ManageCarController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        CarDAO cdb = new CarDAO();
        HttpSession session = request.getSession(true);
        Account a = (Account) session.getAttribute("user");
        if (action.equalsIgnoreCase("view")) {
            request.setAttribute("listCar", cdb.getCarForOwner(a.getUsername()));
            request.getRequestDispatcher("/pages/manageCar.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("edit")) {
            ImageDAO idb = new ImageDAO();
            List<Image> listImage = idb.getImageByCarid(Integer.parseInt(request.getParameter("id")));
            System.out.println(listImage.isEmpty());
            request.setAttribute("listImage", listImage);
            request.setAttribute("car", cdb.getCarByID(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/pages/editCar.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("delete")) {
            cdb.delete(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("listCar", cdb.getCarForOwner(a.getUsername()));
            request.getRequestDispatcher("/pages/manageCar.jsp").forward(request, response);
        }
        if (action.equalsIgnoreCase("save")) {
            Car car = cdb.getCarByID(Integer.parseInt(request.getParameter("id")));
            int carid = Integer.parseInt(request.getParameter("id"));
            String owner = car.getOwner();
            String brand = car.getBrand();
            String model = car.getModel();
            String type = request.getParameter("type");
            String tranmission = request.getParameter("tranmission");
            int seat = Integer.parseInt(request.getParameter("seat"));
            int door = Integer.parseInt(request.getParameter("door"));
            double price = Double.parseDouble(request.getParameter("price"));
            String overview = request.getParameter("overview").trim().isEmpty() ? "None" : request.getParameter("overview");
            String description = request.getParameter("description").trim().isEmpty() ? "None" : request.getParameter("description");
            String view = overview + " /" + description;
            String fileName = null;
            String image = null;
            if (request.getParameter("changeavatar") == null) {
                cdb.updateCar(new Car(carid, owner, brand, model, type, tranmission, seat, door, price, car.getImage(), view));
            } else {
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
                    for (Part part : request.getParts()) {
                        //Danh mục các phần đã upload lên(Có thể là nhiều file).
                        fileName = extractFileName(part);
                        if (fileName != null && fileName.length() > 0) {
                            filePath = fullSavePath + File.separator + owner.replaceAll("\\s+", "") + "0" + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                            // Ghi vào file.
                            part.write(filePath);
                            break;
                        }
                    }
                    for (Part part : request.getParts()) {
                        fileName = extractFileName(part);
                        if (fileName != null && fileName.length() > 0) {
                            filePathRoot = fullSavePathRoot + File.separator + owner.replaceAll("\\s+", "") + "0" + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                            image = owner.replaceAll("\\s+", "") + "0" + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                            part.write(filePathRoot);
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                cdb.updateCar(new Car(carid, owner, brand, model, type, tranmission, seat, door, price, image, view));
            }
            if (request.getParameter("changeDetailImage") != null) {
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
                            if (i == 0) {
                                i++;
                                continue;
                            }
                            filePath = fullSavePath + File.separator + owner.replaceAll("\\s+", "") + i + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                            listFileName.add(owner.replaceAll("\\s+", "") + i + brand + model + fileName.substring(fileName.lastIndexOf('.')));
                            i++;
                            // Ghi vào file.
                            part.write(filePath);
                        }
                    }
                    i = 0;
                    for (Part part : request.getParts()) {
                        fileName = extractFileName(part);
                        if (fileName != null && fileName.length() > 0) {
                            if (i == 0) {
                                i++;
                                continue;
                            }
                            filePathRoot = fullSavePathRoot + File.separator + owner.replaceAll("\\s+", "") + i + brand + model + fileName.substring(fileName.lastIndexOf('.'));
                            i++;
                            part.write(filePathRoot);
                        }
                    }
                    ImageDAO idb = new ImageDAO();
                    idb.delete(carid);
                    for (String s : listFileName) {
                        idb.insert(new Image(1, carid, s));
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            request.getRequestDispatcher("/manageCar?action=view").forward(request, response);
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
