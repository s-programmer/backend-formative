<%-- 
    Document   : admins
    Created on : Jul 20, 2024, 5:19:01 AM
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainer Evaluation Management System</title>
    <link rel="stylesheet" type="text/css" href="fontawesome-free-6.5.2-web/css/all.css">
</head>
<style>
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

header {
    background-color: #002D72;
    color: white;
    padding: 10px 0;
    text-align: center;
}

nav {
    background-color: grey;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

nav ul li {
    margin: 0 15px;
    position: relative;
}

nav ul li a {
    color: white;
    text-decoration: none;
    padding: 10px 15px;
    display: block;
}

nav ul li ul {
    display: none;
    position: absolute;
    background-color: grey;
    top: 100%;
    left: 0;
    padding: 0;
    list-style-type: none;
    z-index: 1000;
}

nav ul li:hover ul {
    display: block;
}

nav ul li ul li {
    width: 150px;
}

nav ul li ul li a {
    padding: 10px;
}

nav ul .icons a img {
    width: 20px;
    height: 20px;
    margin-left: 5px;
}

.logout {
    color: red;
}

main {
    padding: 20px;
    text-align: center;
}

.dashboard {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
}

.card {
    background-color: white;
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: left;
}

.card h2 {
    margin-top: 0;
}

.progress {
    background-color: #f0f0f0;
    border-radius: 4px;
    overflow: hidden;
}

.progress-bar {
    background-color: #002D72;
    height: 10px;
    border-radius: 4px 0 0 4px;
}

.notifications ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

.notifications li {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
    border-bottom: 1px solid #ccc;
}

.notifications li span {
    cursor: pointer;
}

.clock {
    margin-top: 20px;
    font-size: 24px;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

table th, table td {
    border: 1px solid #ccc;
    padding: 8px;
    text-align: center;
}

table th {
    background-color: #f0f0f0;
}
footer{
    background-color:#002D72;
    color: white;
    text-align: center;
    height:100px;
}
</style>
<body>
    <header>
        <h1>TRAINER EVALUATION MANAGEMENT SYSTEM</h1>
    </header>
    <nav>
        <ul>
            <li><a href="#">Overview</a></li>
            <li><a href="#">Evaluations</a>
                <ul>
                    <li><a href="#">Submenu 1</a></li>
                    <li><a href="#">Submenu 2</a></li>
                </ul>
            </li>
            <li><a href="#">Trainers</a>
                <ul>
                    <li><a href="#">Trainer 1</a></li>
                    <li><a href="#">Trainer 2</a></li>
                </ul>
            </li>
            <li><a href="#">Analysis & Report</a></li>
            <li><a href="#">Feedback</a></li>
            <li class="icons">
                <a href="#">Notifications</a>
            </li>
            <li class="icons">
                <a href="#">Messages</a>
            </li>
            <li class="icons">
                <a href="logout" style="color:red;">Logout</a>
        </ul>
    </nav>
    <main>
        <div class="dashboard">
            <div class="card">
                <h2>System Overview Analysis</h2><center>
                    <img src="statistics.png" width="300px" height="200px"></center>
            </div>
            <div class="card">
                <h2 style="text-align:center;">New Comments</h2>
                <p style="text-align:center;color:lightgray;margin-top:40px;">All comments will be appeared here</p>
            </div>
            <div class="card notifications">
                <h2>Notifications</h2>
                <ul>
                    <li>Evaluator asks for permission <span>&#x2713;</span> <span>&#x2715;</span></li>
                    <li>Trainer shared feedback <span>&#x2713;</span> <span>&#x2715;</span></li>
                    <li>Monthly report generated <span>&#x2713;</span> <span>&#x2715;</span></li>
                </ul>
            </div>
            <div class="card">
                <h2>Trainers Performances</h2>
                <p style="font-size:40px; font-weight: bold;">90%</p>
                <div class="progress"><div class="progress-bar" style="width: 90%;"></div></div>
            </div>
            <div class="card">
                <h2>Evaluators</h2>
                <p style="font-size:40px; font-weight: bold;">75%</p>
                <div class="progress"><div class="progress-bar" style="width: 75%;"></div></div>
            </div>
            <div class="card">
                <h2>Monthly System Users</h2>
                <table>
                    <tr><th>User</th><th>Activity</th><th>Time</th></tr>
                    <tr><td>Trainer</td><td>Grading</td><td>169h 15m</td></tr>
                    <tr><td>Evaluator</td><td>Evaluating</td><td>174h 38m</td></tr>
                    <tr><td>Students</td><td>Viewing</td><td>7h 9m</td></tr>
                </table>
                <a href="#">View more</a>
            </div>
        </div>
        <div class="clock">
            <span id="clock">09:27:55</span>
        </div>
    </main>
    <script>
        function updateClock() {
            const now = new Date();
            const hours = String(now.getHours()).padStart(2, '0');
            const minutes = String(now.getMinutes()).padStart(2, '0');
            const seconds = String(now.getSeconds()).padStart(2, '0');
            document.getElementById('clock').textContent = `${hours}:${minutes}:${seconds}`;
        }
        setInterval(updateClock, 1000);
        updateClock();
    </script>
    <footer><br><br>Trainer Evaluation Management System all rights reserved</footer>
</body>
</html>

