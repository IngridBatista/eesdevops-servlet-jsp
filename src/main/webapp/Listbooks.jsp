<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.uece.eesdevops.aplicacao.model.BookEntity"%>
<%@ page import="br.uece.eesdevops.aplicacao.control.BookControl"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>List books</title>
    </head>
    <body>
    <form action="books" method="GET">
        <h3>List of books:</h3>
        <br/>
        <table border="1px">
            <%
                List<BookEntity> books = BookControl.list();
            
                for (BookEntity book : books) { %>
                	 <tr>
                        <td>Title</td>
                        <td>Author</td>
                        <td>Resume</td>
                        <td>Release Year</td>
                    </tr>
                    <tr>
                        <td><%=book.getTitle() %></td>
                        <td><%=book.getAuthor() %></td>
                        <td><%=book.getResume() %></td>
                        <td><%=book.getReleaseYear() %></td>
                    </tr>
            <%
                }
            %>
        </table>
        </form>
    </body>
</html>