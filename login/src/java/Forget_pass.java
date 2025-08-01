/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;

/**
 *
 * @author mohit
 */
@WebServlet(urlPatterns = {"/Forget_pass"})
public class Forget_pass extends HttpServlet {

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
        String to = request.getParameter("mail");
        String msg = "Click the link below to reset your password:<br>" +
                     "<a href='http://localhost:8080/login/EditPassword?mail=" + to + "'>Reset Password</a>";

        Mailer.send(to, "Password Reset - Online Music App", msg);

        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>Password Reset Sent</title>");
        out.println("<style>");
        out.println("body {background: linear-gradient(to right, #6a11cb, #2575fc); font-family: Arial, sans-serif; color: #fff; display: flex; justify-content: center; align-items: center; height: 100vh;}");
        out.println(".card {background: white; color: #333; padding: 30px 40px; border-radius: 12px; box-shadow: 0 8px 24px rgba(0,0,0,0.2); max-width: 500px; text-align: center;}");
        out.println("h2 {color: #6a11cb;}");
        out.println("a {text-decoration: none; color: #2575fc; font-weight: bold;}");
        out.println("a:hover {text-decoration: underline;}");
        out.println("</style></head><body>");
        out.println("<div class='card'>");
        out.println("<h2>✅ Reset Link Sent!</h2>");
        out.println("<p>A password reset link has been sent to <strong>" + to + "</strong>.</p>");
        out.println("<p>Please check your inbox and follow the instructions.</p>");
        out.println("<a href='index.html'>Return to Home</a>");
        out.println("</div>");
        out.println("</body></html>");

    } catch (Exception e) {
        e.printStackTrace();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Error</title>");
        out.println("<style>");
        out.println("body {background: #ff4e50; color: white; font-family: sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh;}");
        out.println(".error {background: rgba(0,0,0,0.5); padding: 30px; border-radius: 10px;}");
        out.println("</style></head><body>");
        out.println("<div class='error'>");
        out.println("<h2>❌ An error occurred</h2>");
        out.println("<pre>" + e.getMessage() + "</pre>");
        out.println("</div></body></html>");
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
