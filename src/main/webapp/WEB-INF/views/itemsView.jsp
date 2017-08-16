<%--
  Created by IntelliJ IDEA.
  User: Gateway
  Date: 8/14/2017
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Items</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>

    </tr>
    <c:forEach items= "${iList}" var="item">
        <tr>

            <td>
                    ${item.name}
            </td>
            <td>
                    ${item.description}
            </td>
            <td>
                    ${item.quantity}
            </td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
