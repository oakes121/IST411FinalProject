/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package checkoutServlet;
import shipping.ShippingCalc;

import creditCardValidation.CreditCardValidation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oakes / Roman
 */
public class CheckoutServlet extends HttpServlet {
    
    private double rate;
    private int zip;
    private float lb;
    
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
        try {
            /* TODO output your page here. You may use following sample code. */
          
            String cardNumber = (String) request.getParameter("cardNumber");
            String custName = (String) request.getParameter("CustName"); 
            //String weight = (String) request.getAttribute("weight");
            String address = (String) request.getParameter("Street Address");
            String city = (String) request.getParameter("City");
            String state = (String) request.getParameter("State");
            String zipCode = (String) request.getParameter("zipCode");
            String price = (String) request.getAttribute("price");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductToCheckout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            
            rate = ShippingCalc.getRate(zip,lb);   
            
            if (CreditCardValidation.validate(cardNumber)) {
                
               // rate = ShippingCalc.getRate(zipCode,lb);              
                                
                request.setAttribute("CustName", custName);
                request.setAttribute("Street Address", address);
                request.setAttribute("City", city);
                request.setAttribute("State", state);
                request.setAttribute("zipCode", zipCode);
                request.setAttribute("Price", price);
                request.setAttribute("rate", rate);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmTotal.jsp");
                dispatcher.forward(request, response);                   
            } 
            
            else {
                request.setAttribute("error", cardNumber);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/errorPage.jsp");
                dispatcher.forward(request, response);  
            }
            
        } finally {
            out.close();
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
