/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prodToCheckout;

import databaseInterface.DatabaseInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.Product;

/**
 *
 * @author Oakes
 */
public class ProductToCheckout extends HttpServlet {
    ArrayList<Product> selected = new ArrayList<Product>();

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
            DatabaseInterface dbi = new DatabaseInterface(1);
            ArrayList<Product> fruits =  dbi.getProducts();
                  
            DatabaseInterface dbi2 = new DatabaseInterface(2);
            ArrayList<Product> meats=  dbi2.getProducts();
            
            String bananas = request.getParameter("fruitCheck0");
            String apples = request.getParameter("fruitCheck1");
            String grapes = request.getParameter("fruitCheck2");
            String steak = request.getParameter("meatCheck0");
            String chicken = request.getParameter("meatCheck1");
            String pork = request.getParameter("meatCheck2");
            
            
            addProduct(bananas, fruits, 0);
            addProduct(apples, fruits, 1);
            addProduct(grapes, fruits, 2);
            addProduct(steak, meats, 0);
            addProduct(chicken, meats, 1);
            addProduct(pork, meats, 2);
            
            request.setAttribute("selected", selected); 
            
            String url = "/checkout.jsp";
                  RequestDispatcher dispatcher =
                          getServletContext().getRequestDispatcher(url);
                  dispatcher.forward(request, response); 
            
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductToCheckout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(fruits.get(0).getTitle());
            out.println(apples == null ? "false" : "true");
            out.println(grapes == null ? "false" : "true");
            out.println(steak == null ? "false" : "true");
            out.println(chicken == null ? "false" : "true");
            out.println(pork == null ? "false" : "true");
            out.println("</body>");
            out.println("</html>"); */
        } finally {
            out.close();
        }
    }
    
    private void addProduct(String product, ArrayList<Product> fruitOrMeat, int index) {
        if (product != null)
            selected.add(fruitOrMeat.get(index));
            
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
