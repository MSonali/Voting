<%-- 
    Document   : index
    Created on : Apr 5, 2017, 3:24:46 PM
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
        <style>
            body{
                background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg) ;
                background-size: cover;
                background-repeat: no-repeat;
            }
        </style>
        <title>Login Page</title>
    </head>
    <body id="bgimg">
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
            <form action="Login" method="post">
                <div class="form-group">
                    <label for="uname">UserName:</label>
                    <input type="text" class="form-control" name="userName" placeholder="Enter UserName">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" name="pwd" placeholder="Enter password">
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <table> 
                    <tr>
                        <td>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </td>
                        <td>
                            <a class="btn btn-default" href="reg.jsp">Register</a>
                        </td>
                    </tr>
                </table>

            </form>
        </div>


    </body>
</html>
