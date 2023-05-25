/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.uakron.munashabab;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author munashabab
 */
public class TuitionCalculatorServlet extends HttpServlet {

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
        try{
            String rCode=request.getParameter("residencyCode");
            int creditHours=Integer.parseInt(request.getParameter("creditHours"));
            TuitionCalculator tuitionCalculator= new TuitionCalculator();
            tuitionCalculator.setResidencyCode(rCode);
            tuitionCalculator.setCreditHours(creditHours);
            double tuition=tuitionCalculator.getTuition();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tuition Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tuition Calculator</h1>");
            out.println("<form name=\"myForm\" method=\"get\" action=\"TuitionCalculatorServlet\" >");
            out.println("<table >");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>Residency Code: </td>");
            out.println("<td><select name=\"residencyCode\">");
            out.println("<option value=\"IC\">In County</option>");
            out.println("<option value=\"OC\">Out of County</option>");
            out.println("<option value=\"OS\">Out of State</option>");
            out.println("</select></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Credit Hours: </td>");
            out.println("<td><input type=\"text\" name=\"creditHours\" value=\"\" size=\"2\" /></td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("<input type=\"reset\" value=\"Clear\" name=\"clear\" />");
            out.println("<input type=\"submit\" value=\"Calculate\" name=\"calculate\" />");
            out.println("</form>");
            out.println("The tuition is for " +creditHours +" credit hour(s) and "+rCode+" residency is :"+ tuition);
            out.println("</body>");
            out.println("</html>");
        }
        catch(NumberFormatException e){
            out.println("danger");
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
