<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<section class="help" id="help">
    <h2>Zmiana Twojego hasła</h2>

    <div class="help--slides active" data-id="1">
        <form:form method="post" modelAttribute="user">
            <div class="form-group">
<%--                <form:input path="password" type="password" placeholder="Podaj nowe hasło" />--%>
                <input type="password" name="password" placeholder="Podaj nowe hasło" />

                <form:errors path="password" element="div" />
            </div>
            <div class="form-group">
                <input type="password" name="password2" placeholder="Powtórz hasło" />
            </div>

            <form:input path="username" type="hidden" />

            <div class="form-group form-group--buttons">
                <a href="<c:url value="/user"/>" class="btn btn--without-border">Powrót</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn" type="submit">Aktualizuj hasło</button>
            </div>
        </form:form>
    </div>

</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>