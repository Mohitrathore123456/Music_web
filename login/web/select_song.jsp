<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Select Song</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      background: url('image/music.jpg') no-repeat center center fixed;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .form-container {
      background: rgba(255, 255, 255, 0.15);
      backdrop-filter: blur(10px);
      border-radius: 16px;
      padding: 40px 30px;
      box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
      width: 100%;
      max-width: 400px;
      text-align: center;
    }

    .form-container h2 {
      color: #ffffff;
      margin-bottom: 25px;
      font-size: 24px;
      letter-spacing: 1px;
    }

    .form-container label {
      display: block;
      color: #ffffff;
      margin-bottom: 8px;
      font-size: 16px;
      text-align: left;
    }

    .form-container input[type="text"] {
      width: 100%;
      padding: 12px;
      border-radius: 10px;
      border: none;
      outline: none;
      font-size: 15px;
      margin-bottom: 20px;
      background-color: rgba(255, 255, 255, 0.8);
    }

    .form-container button {
      width: 100%;
      padding: 12px;
      background: linear-gradient(to right, #00b4db, #0083b0);
      color: white;
      border: none;
      border-radius: 10px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: 0.3s ease;
    }

    .form-container button:hover {
      transform: translateY(-2px);
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    }

  </style>
</head>
<body>

  <div class="form-container">
    <h2>🎵 Enter Song Information</h2>
    <form action="fetch_song.jsp" method="POST">
      <label for="song_Name">Song Name:</label>
      <input type="text" id="song_Name" name="singer" placeholder="e.g., Shape of You" required>
      <button type="submit">Submit</button>
    </form>
  </div>

</body>
</html>
