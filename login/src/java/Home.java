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
 * @author administration
 */
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {

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
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Welcome Home</title>");
            out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;600&display=swap' rel='stylesheet'>");
            out.println("<style>");
            out.println("body {");
            out.println("  margin: 0;");
            out.println("  padding: 0;");
            out.println("  height: 100vh;");
            out.println("  display: flex;");
            out.println("  justify-content: center;");
            out.println("  align-items: center;");
            out.println("  font-family: 'Poppins', sans-serif;");
            out.println("  background: url('image/home.jpg') no-repeat center center fixed;");
            out.println("  background-size: cover;");
            out.println("  color: #fff;");
            out.println("}");

            out.println(".container {");
            out.println("  background: rgba(255, 255, 255, 0.1);");
            out.println("  padding: 40px 60px;");
            out.println("  border-radius: 16px;");
            out.println("  backdrop-filter: blur(10px);");
            out.println("  text-align: center;");
            out.println("}");

            out.println("h1 {");
            out.println("  font-size: 42px;");
            out.println("  font-weight: 600;");
            out.println("  margin-bottom: 10px;");
            out.println("}");

            out.println("h2 {");
            out.println("  font-size: 26px;");
            out.println("  font-weight: 300;");
            out.println("  margin-bottom: 30px;");
            out.println("}");

            out.println("a.button {");
            out.println("  display: inline-block;");
            out.println("  padding: 12px 25px;");
            out.println("  margin: 10px;");
            out.println("  border-radius: 8px;");
            out.println("  text-decoration: none;");
            out.println("  font-size: 18px;");
            out.println("  font-weight: 500;");
            out.println("  transition: background 0.3s;");
            out.println("}");

            out.println("a.profile {");
            out.println("  background-color: #ff6ec4; /* pink shade */");
            out.println("  color: white;");
            out.println("}");

            out.println("a.profile:hover {");
            out.println("  background-color: #ff2e9a;");
            out.println("}");

            out.println("a.logout {");
            out.println("  background-color: #ff9a9e; /* light pink */");
            out.println("  color: white;");
            out.println("}");

            out.println("a.logout:hover {");
            out.println("  background-color: #ff5e6c;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Welcome Home</h1>");
            out.println("<h2>" + name + "</h2>");
            out.println("<a href='Profile' class='button profile'>Go to Profile</a>");
          
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } else {
            out.println("<h2 style='color: red; text-align: center;'>Please Login First </h2> <br>");
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
