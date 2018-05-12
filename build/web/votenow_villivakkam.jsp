<%-- 
    Document   : votenow_villivakkam
    Created on : Apr 22, 2017, 6:25:22 PM
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
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <title>Villivakkam Constituency</title>
    </head>
    <body>
        <div class="page-header text-center">
            <h1>Villivakkam Constituency</h1>
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

            <form action="VoteNow" method="post">
                <div class="page-header text-center">
                <h2>VOTE NOW!</h2>
                </div>
                <div class="radio">
                    <label><input type="radio" name="candirad" value="candidate1">Candidate 1</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="candirad" value="candidate2">Candidate 2</label>
                </div>
                <div class="radio disabled">
                    <label><input type="radio" name="candirad" value="candidate3">Candidate 3</label>
                </div>
                <div>
                    <button type="submit" class="btn btn-default">Vote</button>
                </div>
            </form>
        </div>
    </body>
</html>
