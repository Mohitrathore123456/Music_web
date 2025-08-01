/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mohit
 */
@WebServlet(urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

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
        HttpSession hs = request.getSession(false);
        if (hs != null) {

            RequestDispatcher rd = request.getRequestDispatcher("logout.html");
            rd.include(request, response);
            String name = (String) hs.getAttribute("naam");
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<meta charset='UTF-8'>");
out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
out.println("<title>Profile</title>");
out.println("<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@300;500&display=swap' rel='stylesheet'>");
out.println("<style>");
out.println("body {");
out.println("  margin: 0;");
out.println("  padding: 0;");
out.println("  height: 100vh;");
out.println("  font-family: 'Roboto', sans-serif;");
out.println("  background: url('image/background2.jpg') no-repeat center center/cover;");
out.println("  display: flex;");
out.println("  align-items: center;");
out.println("  justify-content: center;");
out.println("  position: relative;");
out.println("}");
out.println("body::before {");
out.println("  content: ''; ");
out.println("  position: absolute;");
out.println("  top: 0;");
out.println("  left: 0;");
out.println("  right: 0;");
out.println("  bottom: 0;");
out.println("  background-color: rgba(0, 0, 0, 0.5);");
out.println("  z-index: 0;");
out.println("}");
out.println(".container {");
out.println("  position: relative;");
out.println("  z-index: 1;");
out.println("  text-align: center;");
out.println("  background: rgba(255, 255, 255, 0.1);");
out.println("  padding: 40px;");
out.println("  border-radius: 15px;");
out.println("  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);");
out.println("  backdrop-filter: blur(10px);");
out.println("  color: white;");
out.println("}");
out.println("h1 {");
out.println("  font-size: 48px;");
out.println("  margin-bottom: 20px;");
out.println("}");
out.println("a.button {");
out.println("  display: inline-block;");
out.println("  margin: 10px;");
out.println("  padding: 12px 25px;");
out.println("  font-size: 18px;");
out.println("  color: white;");
out.println("  background-color: #007BFF;");
out.println("  border: none;");
out.println("  border-radius: 8px;");
out.println("  text-decoration: none;");
out.println("  transition: background-color 0.3s ease;");
out.println("}");
out.println("a.button:hover {");
out.println("  background-color: #0056b3;");
out.println("}");
out.println("</style>");
out.println("</head>");
out.println("<body>");

out.println("<div class='container'>");
out.println("<h1>" + name + "'s Profile</h1>");
out.println("<a class='button' href='select_song.jsp'>🎵 Songs</a>");
out.println("<a class='button' href='category.jsp'>🎧 Song Categories</a>");
out.println("</div>");

out.println("</body>");
out.println("</html>");


        } else {
            out.println("Please Login First");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);

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
