<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: Torva
  Date: 21.10.2022
  Time: 14:28
--%>
<html>
<head>
    <link rel="stylesheet" href="css/styles.css" type="text/css">
    <title>Calculator</title>
</head>
<body>
    <div id="root"/>
        <h3>
            Calculate The Monthly Payment for a houseing loan
        </h3>
        <form action="/calculator" method="post">
            <label class="breaklines">
                Amount :
                <input type="text" id="amount" name="amount">
            </label>
            <label class="breaklines">
                Duration :
                <input type="text" id="duration" name="duration">
            </label>
            <br />
            <button type="submit" value="Calculate" name="button">
                Calculate
            </button>
            <label class="movelabel">
                <p>${monthlyPayment}</p>
                <p style="color: red">${durationisnull}</p>
                <p style="color: red">${unsuitable}</p>
                <p style="color: red">${invalid}</p>
            </label>
        </form>
</body>
</html>
