/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class SubmitOrderrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        String email = request.getParameter("emailName");
        String name = request.getParameter("nameName");
        String phone = request.getParameter("phoneName");
        String address = request.getParameter("addressName");
        String note = request.getParameter("noteName");
        String city = request.getParameter("cityName");
        String district = request.getParameter("districName");
        String payment = request.getParameter("payment");
        String fullAddress = address + "-" + district + "-" + city;

        request.setAttribute("email", email);
        request.setAttribute("payment", payment);
        request.getRequestDispatcher("TestLinhTinh.jsp").forward(request, response);

    }

    public static void main(String[] args) {
        String x1 = "he he";
        String x2 = "ho ho";

        String add = x1 +"-"+ x2;

        System.out.println(add);

    }
}
