/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dao.ProductDAO;
import dao.WorkAssignmentDAO;
import dto.WorkAssignmentDTO;
import entity.Department;
import entity.Employee;
import entity.Product;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkerAssignmentController extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            List<WorkAssignmentDTO> plans = new ArrayList<>();
            
            WorkAssignmentDAO d = new WorkAssignmentDAO();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("LOGIN_USER");
            
            Department department = new Department();
            DepartmentDAO dd = new DepartmentDAO();
            department = dd.getDepartmentByEid(user.getEid());
            plans = d.getAllByDepartmentId(department.getdId());
            
            ProductDAO pd = new ProductDAO();
            List<Product> products = new ArrayList<>();
            products = pd.getAllProduct();
            
            EmployeeDAO ed = new EmployeeDAO();
            List<Employee> employeeList = new ArrayList<>();
            employeeList = ed.getAllEmployeeByDid(department.getdId());
            
            request.setAttribute("products", products);
            request.setAttribute("list", plans);
            request.setAttribute("employees", employeeList);
            
            request.getRequestDispatcher("worker_assignment.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(WorkerAssignmentController.class.getName()).log(Level.SEVERE, null, ex);
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
