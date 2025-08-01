<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Filtered Songs</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('image/music.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Poppins', sans-serif;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            width: 95%;
            max-width: 1100px;
            overflow-x: auto;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #ffffff;
            font-size: 28px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.15);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid rgba(255, 255, 255, 0.3);
            text-align: center;
            color: #ffffff;
        }

        th {
            background-color: rgba(0, 0, 0, 0.3);
        }

        audio {
            width: 180px;
        }

        .not-found {
            text-align: center;
            color: #ffdddd;
            font-size: 22px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            try {
                String singer = request.getParameter("singer");
                String type = request.getParameter("type");

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "mohitrathore");

                PreparedStatement ps = cn.prepareStatement("SELECT * FROM song WHERE name = ?");
                ps.setString(1, singer);
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
        %>
        <h2>🎶 Songs Found</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Singer</th>
                <th>Movie</th>
                <th>Language</th>
                <th>Song Type</th>
                <th>Writer</th>
                <th>Play</th>
            </tr>
            <%
                do {
                    String id = rs.getString("song_id");
                    String name = rs.getString("name");
                    String singerr = rs.getString("singer");
                    String movie_album = rs.getString("movie_album");
                    String language = rs.getString("language");
                    String s_type = rs.getString("song_type");
                    String writer = rs.getString("writer");
                    String fileName = rs.getString("filename");
            %>
            <tr>
                <td><%= id %></td>
                <td><%= name %></td>
                <td><%= singerr %></td>
                <td><%= movie_album %></td>
                <td><%= language %></td>
                <td><%= s_type %></td>
                <td><%= writer %></td>
                <td>
                    <audio controls>
                        <source src="music/<%= fileName %>" type="audio/mpeg">
                        Your browser does not support the audio element.
                    </audio>
                </td>
            </tr>
            <% } while (rs.next()); %>
        </table>
        <%
            } else {
        %>
            <div class="not-found">❌ Song Not Found</div>
        <%
            }
            cn.close();
        } catch (Exception ex) {
            out.println("<p style='color:red;'>Error: " + ex.getMessage() + "</p>");
        }
        %>
    </div>
</body>
</html>
