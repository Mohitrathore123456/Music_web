<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Choose Song Category</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            min-height: 100vh;
            background: url('image/music.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 40px 20px;
            color: white;
        }

        .container {
            width: 100%;
            max-width: 1100px;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-bottom: 30px;
            flex-wrap: wrap;
        }

        select, input[type="submit"] {
            padding: 10px 15px;
            border-radius: 8px;
            border: none;
            font-size: 15px;
            outline: none;
        }

        select {
            background-color: rgba(255, 255, 255, 0.8);
            color: #000;
        }

        input[type="submit"] {
            background: linear-gradient(to right, #00b4db, #0083b0);
            color: white;
            cursor: pointer;
            transition: 0.3s ease;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            transform: scale(1.03);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: rgba(255, 255, 255, 0.15);
        }

        th, td {
            border: 1px solid rgba(255, 255, 255, 0.3);
            padding: 12px;
            text-align: center;
            color: white;
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
            font-size: 20px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🎧 Choose Song Category</h2>
        <form action="category.jsp" method="get">
            <select name="song_type" required>
                <option value="" disabled selected>Choose Song Type</option>
                <option>Romantic Song</option>
                <option>Item Song</option>
                <option>Sad Song</option>
                <option>Old Song</option>
                <option>Lofi Song</option>
                <option>Pop Song</option>
                <option>Remix Song</option>
                <option>Bhajan Keertan</option>
            </select>
            <input type="submit" value="Choose" name="btn">
        </form>

        <%
            String btn = request.getParameter("btn");
            if (btn != null) {
                try {
                    String cat = request.getParameter("song_type");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "mohitrathore");

                    PreparedStatement ps = cn.prepareStatement("SELECT * FROM song WHERE song_type = ?");
                    ps.setString(1, cat);

                    ResultSet rs = ps.executeQuery();

                    boolean hasSongs = false;
        %>

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
                while (rs.next()) {
                    hasSongs = true;
                    String id = rs.getString("song_id");
                    String name = rs.getString("name");
                    String singer = rs.getString("singer");
                    String movie_album = rs.getString("movie_album");
                    String language = rs.getString("language");
                    String s_type = rs.getString("song_type");
                    String writer = rs.getString("writer");
                    String fileName = rs.getString("filename");
            %>

            <tr>
                <td><%= id %></td>
                <td><%= name %></td>
                <td><%= singer %></td>
                <td><%= movie_album %></td>
                <td><%= language %></td>
                <td><%= s_type %></td>
                <td><%= writer %></td>
                <td>
                    <audio controls>
                        <source src="song/<%= fileName %>" type="audio/mpeg">
                        Your browser does not support the audio tag.
                    </audio>
                </td>
            </tr>

            <%
                }
                if (!hasSongs) {
            %>
                <tr>
                    <td colspan="8" class="not-found">❌ No songs found for selected category.</td>
                </tr>
            <%
                }
                cn.close();
            } catch (Exception ex) {
                out.println("<p style='color:red;'>Error: " + ex.getMessage() + "</p>");
            }
        }
        %>
        </table>
    </div>
</body>
</html>
