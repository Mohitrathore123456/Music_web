<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add New Song</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <style>
            
            body {
                margin: 0;
                font-family: 'Poppins', sans-serif;
             background-color: #0d1b2a;

                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }


            .container {
                background: rgba(255, 255, 255, 0.15);
                padding: 40px;
                width: 420px;
                border-radius: 15px;
                box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.2);
                backdrop-filter: blur(10px);
                -webkit-backdrop-filter: blur(10px);
                color: #fff;
            }

            h2 {
                text-align: center;
                margin-bottom: 25px;
                font-weight: 600;
                color: #ffffff;
            }

            input[type="text"], input[type="file"], select {
                width: 100%;
                padding: 12px;
                margin: 10px 0 18px 0;
                border: none;
                border-radius: 8px;
                background: rgba(255, 255, 255, 0.1);
                color: #fff;
                font-size: 14px;
            }
            

            input[type="file"] {
                background-color: rgba(200, 255, 255, 0.1);
            }

            input[type="submit"] {
                width: 100%;
                padding: 14px;
                border: none;
                background: linear-gradient(to right, #00c6ff, #0072ff);
                color: white;
                font-weight: 600;
                font-size: 15px;
                border-radius: 8px;
                cursor: pointer;
                transition: all 0.3s ease;
            }

            input[type="submit"]:hover {
                background: linear-gradient(to right, #0072ff, #00c6ff);
                transform: scale(1.03);
            }

            label {
                font-size: 13px;
                margin-left: 2px;
                color: #e2e2e2;
            }

            select {
                appearance: none;
            }

            option {
                color: black;
            }
        </style>

        <script>
            function validateForm() {
                const fields = ["name", "singer", "movie_album", "language", "writer"];
                for (let id of fields) {
                    if (document.forms["songForm"][id].value.trim() === "") {
                        alert("Please fill out the " + id.replace("_", " ") + " field.");
                        return false;
                    }
                }

                const songType = document.forms["songForm"]["song_type"].value;
                if (songType === "Choose Song Type") {
                    alert("Please select a song type.");
                    return false;
                }

                const file = document.forms["songForm"]["song"].value;
                if (file === "") {
                    alert("Please upload a song file.");
                    return false;
                }

                return true;
            }
        </script>
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");
            if (email != null) {
        %>
        <%@ include file="admin_logout.html" %>

        <div class="container">
            <h2>Upload a New Song</h2>
            <form name="songForm" action="Upload" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
                <input type="text" name="name" placeholder="Song Name" />
                <input type="text" name="singer" placeholder="Singer Name" />
                <input type="text" name="movie_album" placeholder="Movie / Album" />
                <input type="text" name="language" placeholder="Language" />
                <input type="text" name="writer" placeholder="Writer / Lyricist" />
                <label>Upload Song File</label>
                <input type="file" name="song" />
                <select name="song_type">
                    <option>Choose Song Type</option>
                    <option>Romantic Song</option>
                    <option>Item Song</option>
                    <option>Sad Song</option>
                    <option>Old Song</option>
                    <option>Lofi Song</option>
                    <option>Pop Song</option>
                    <option>Remix Song</option>
                    <option>Bhajan Keertan</option>
                </select>
                <input type="submit" value="Upload Song" />
            </form>
        </div>

        <%
        } else {
        %>
        <div class="container">
            <h2>Please login first</h2>
            <%@ include file="admin_login.html" %>
        </div>
        <%
            }
        %>
    </body>
</html>
