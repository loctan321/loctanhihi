<%-- 
    Document   : insert
    Created on : Apr 23, 2021, 9:39:56 PM
    Author     : hd
    Your code here. Do not delete this comment
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert New Product</title>
    </head>
    <body>
        <h1>Create New Product</h1>
        <form action="MainController">
            ID: <input type="text" name="productID" value="" required/><br>
            Name: <input type="text" name="name" value="${param.name}" required/><br>
            description: <input type="text" name="description" value="${param.description}" required/><br>
            price: <input type="number" name="price" value="${param.price}" required/><br>
            cpu: <input type="number" name="cpu" value="${param.cpu}" required/><br>
            create Date <input type="date" name="createDate" value="${param.createDate}" required/><br>
            <br>
          
            <input type="submit" value="Insert" name="action" />
        </form>
    </body>
</html>
