<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Insert books</title>
    </head>
    <body>
    </br>
    <form action="books_entities" method="POST">
    <h3>Register books:</h3>
   	Title:<input type="text" name="title"/><br>
	Author:<input type="text" name="author"/><br>
	Resume:<input type="text" name="resume"/><br>
	Release Year:<input type="text" name="releaseYear"/><br>

	<input type="submit" value="register"/>
	</form>

     </body>
</html>
