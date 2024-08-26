<%-- 
    Document   : LoginPage
    Created on : 25-Mar-2024, 10:53:15 am
    Author     : tarun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="Log" method="POST">
                <input type="text" placeholder="Enter your name" name="nam"/>
                <br />
                <input type="password" placeholder="Enter password" name="passwd"/>
                <br />
                <input type="submit"/>
            </form>
        </div>
    </body>
</html>
