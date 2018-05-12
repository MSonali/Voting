<%-- 
    Document   : Timer
    Created on : Aug 8, 2017, 6:27:58 PM
    Author     : Sonali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*,java.util.*;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width initial-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
        body{
            background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg);
            background-size: cover;
            background-repeat: no-repeat;
        }
        </style>
        <title>Timer</title>
    </head>
    <body>
        <form action="homepage.jsp">
            <div>
                <label>Start Time</label><br>
                <input type="text" name="startTimeHours" placeholder="Hours"><br>
                <input type="text" name="startTimeMinutes" placeholder="Minutes"><br>
                <input type="text" name="startTimeSeconds" placeholder="Seconds"><br>
                <input type="text" name="startTimeAm_Pm" placeholder="AM/PM"><br>
            </div>
            <div>
                <label>End Time</label>
                <input type="text" name="endTimeHours" placeholder="Hours"><br>
                <input type="text" name="endTimeMinutes" placeholder="Minutes"><br>
                <input type="text" name="endTimeSeconds" placeholder="Seconds"><br>
                <input type="text" name="endTimeAm_Pm" placeholder="AM/PM"><br>
            </div>
        </form>
        <%
            Date date = new Date();
            System.out.print(date);
            response.setIntHeader("Response", 1000);
            Calendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR);
            int minutes = calendar.get(Calendar.MINUTE);
            int startHours = Integer.parseInt(request.getParameter("startTimeHours"));
            int startMinutes = Integer.parseInt(request.getParameter("startTimeMinutes"));
            String start_am_pm = request.getParameter("StartTimrAm_Pm");
            if (start_am_pm.equalsIgnoreCase("pm")) {
                startHours += 12;
            }
            int endHours = Integer.parseInt(request.getParameter("endTimeHours"));
            int endMinutes = Integer.parseInt(request.getParameter("endTimeMinutes"));
            String end_am_pm = request.getParameter("endTimeAm_Pm");
            if (end_am_pm.equalsIgnoreCase("pm")) {
                endHours += 12;
            }
            if (endHours > hour && startHours < hour) {
        %>
        <script>
            function formActionAccept() {
        </script>
        <form>
            <input type="submit" value="SUBMIT">
        </form>
        <script>
            }
        </script>

        <%            } else if (endHours == hour) {
            if (minutes < endMinutes) {
        %>
        <script>  formActionAccept();</script>
        <%
        } else {
        %>
        <script>formActionExpired();</script>
        <%
            }
        } else if (startHours == hour) {
            if (minutes > startMinutes) {
        %>
        <script>formActionAccept();</script>
        <%
            }
        } else {
        %>
        <script>
            function formActionExpired() {
        </script>
        <%
            out.print("<h1 align ='center' style='color:red'> TimeExpired!</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("Timer.jsp");
            rd.include(request, response);
        %>
        <script>}</script>
        <%
            }
        %>

    </body>
</html>

