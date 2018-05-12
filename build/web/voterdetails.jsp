<%-- 
    Document   : voterdetails
    Created on : Apr 5, 2017, 3:34:48 PM
    Author     : Sonali
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
        <style>
            body{
                background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg)  ;
                background-size: cover;
                background-repeat: no-repeat;

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

        </div>
        <div class="container">
            <form action ="VoterDetails" method="post">
                <div class="form-group">
                    <label for="rno">Aadhar Number:</label>
                    <input type="text" class="form-control" name="ano" placeholder="Enter ano">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" name="pwd" placeholder="Enter password">
                </div>
                <div>
                    <button type="submit" class="btn btn-default ">Get UID</button>
                </div>
                <div class="form-group">
                    <label for="uid">UID:</label>
                    ${uid}
                </div>

                <div>
                    <c:if test="${empty uid}">
                        <a class="btn btn-default" href="Exit.jsp">OK</a>
                    </c:if>
                    <c:if test="${not empty uid}">
                        <a class="btn btn-default" href="check.jsp">OK</a>

                    </c:if>
                </div>
            </form>
        </div>
    </body>
</html>
