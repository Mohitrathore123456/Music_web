
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Check_Login")
public class Check_Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {

            String email = req.getParameter("mail");
            String pwd = req.getParameter("pass");

//load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //make the connection object
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "mohitrathore");

            //make preparedstatement object
            PreparedStatement ps = cn.prepareStatement("select * from users where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, pwd);

//execute the query
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                HttpSession hs = req.getSession(true);
                hs.setAttribute("naam", name);
                hs.setAttribute("email", email);
                hs.setAttribute("mobile", mobile);
                hs.setAttribute("id", id);
                // RequestDispatcher rd=req.getRequestDispatcher("Home");
                //rd.forward(req, res);
                res.sendRedirect("Home");
            } else {

                out.println("<h2 style='color: red; text-align: center;'>Invalid Email or password</h2>");

                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.include(req, res);

            }

            cn.close();
        } catch (Exception ex) {
            out.println(ex.toString());
        }

    }

}
