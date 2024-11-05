/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PlanDAO;
import entity.PlanDetail;
import entity.WorkAssignment;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AssignWorkerController extends HttpServlet {

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
        String employeeIdString = request.getParameter("employeeId");
        int employeeId = 0;
        int sId = 0;
        
        if (employeeIdString != null && !employeeIdString.isEmpty()) {
            String[] ids = employeeIdString.split("\\|");
            if (ids.length == 2) {
                 employeeId = Integer.parseInt(ids[0]); 
                 sId = Integer.parseInt(ids[1]); 
            } else {
                System.out.println("Invalid employeeId format");
            }
        }
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int planHeaderId = Integer.parseInt(request.getParameter("taskId"));

        String date1 = request.getParameter("date");
        
        PlanDAO d = new PlanDAO();
        int x = d.createPlanDetail(new PlanDetail(0, planHeaderId, sId, date1, quantity));
        d.createWorkAssignment(new WorkAssignment(0,x , employeeId, quantity));
        
        response.sendRedirect("managePlan");

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
