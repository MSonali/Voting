<%-- 
    Document   : candidate
    Created on : Jun 14, 2017, 6:42:51 PM
    Author     : Shyamil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body{
                background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg)   ;
                background-size: cover;
                background-repeat: no-repeat;
            } 
        </style>
        <title>CandidateReg</title>
    </head>
    <body>
        <div class="page-header text-center">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">VotingApp</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active" ><a href="index.jsp">Logout</a></li>
                    </ul>
                </div>
            </nav>

        </div>
        <div class="container">
            <form action="CandidateRegister" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter name">
                </div>
                <div>
                    <button type="submit" class="btn btn-default">ADD</button>
                </div>
            </form>
        </div>
    </body>
</html>
