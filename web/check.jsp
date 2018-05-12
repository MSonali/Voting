<%-- 
    Document   : check
    Created on : Apr 13, 2017, 1:18:56 PM
    Author     : Sonali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>checkpost</title>
        <style>
            body{
               background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg)   ;
               background-repeat: no-repeat;
               background-size: cover;

            }
        </style>
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
 
        <h1> VERIFICATION </h1>
        </div>
        <div class="container">
             <form action="Check" method="post">
                <div class="form-group">
                    <label for="rno">Aadhar Number:</label>
                    <input type="text" class="form-control" name="ano" placeholder="Enter ano">
                </div>
                <div class="form-group">
                    <label for="uid">UID:</label>
                    <input type="text" class="form-control" name="uid" placeholder="Enter uid">
                </div>
                <div>
                    <button type="submit" class="btn btn-default">Check</button>
                </div>
            </form>
        </div>

    </body>
</html>
