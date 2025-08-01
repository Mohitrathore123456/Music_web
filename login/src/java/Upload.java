import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class Upload extends HttpServlet {
    private static final String UPLOAD_DIR = "song";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Create upload path if not exists
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        try {
            // Get form fields
            String songName = request.getParameter("name");
            String singerName = request.getParameter("singer");
            String moviealbum = request.getParameter("movie_album");
            String writer = request.getParameter("writer");
            String song_type = request.getParameter("song_type");
            String language = request.getParameter("language");

            // Get file part
            Part filePart = request.getPart("song");
            String fileName = extractFileName(filePart);

            if (fileName == null || fileName.isEmpty()) {
                out.println("<h3>Error: No file selected.</h3>");
                return;
            }

            // Save file
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);

            // Store metadata in database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/register", "root", "mohitrathore"
            );

            String query = "INSERT INTO song(name, singer, movie_album, language, song_type, writer, filename) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cn.prepareStatement(query);

            stmt.setString(1, songName);
            stmt.setString(2, singerName);
            stmt.setString(3, moviealbum);
            stmt.setString(4, language);
            stmt.setString(5, song_type);
            stmt.setString(6, writer);
            stmt.setString(7, fileName);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<h3>Song uploaded successfully!</h3>");
                RequestDispatcher rd=request.getRequestDispatcher("add_song.jsp");
                rd.include(request, response);
            } else {
                out.println("<h3>Failed to upload song.</h3>");
            }

            cn.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp != null) {
            for (String content : contentDisp.split(";")) {
                if (content.trim().startsWith("filename")) {
                    String fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                    return new File(fileName).getName();
                }
            }
        }
        return null;
    }
}
