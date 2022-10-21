<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Torva
  Date: 21.10.2022
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form action="/calculator" method="post">
        <label>
            Amount :
            <input type="text" id="amount" name="amount">
        </label>
        <label>
            Duration :
            <input type="text" id="duration" name="duration">
        </label>
        <br />
        <p>${suit}</p>
        <p>${invalid}</p>
        <input type="submit" value="Calculate"/>
    </form>
    <label>
        <p>${monthlyPayment}</p>

    </label>
</body>
</html>
