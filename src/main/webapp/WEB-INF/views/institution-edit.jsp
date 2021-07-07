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

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<section class="help" id="help">
    <h2>Dodaj fundację</h2>

    <div class="help--slides active" data-id="1">
        <form:form method="post" modelAttribute="institution">
            <c:if test="${not empty error}">
                <div class="form-group">
                    <div class="alert alert-warning">${error}</div>
                </div>
            </c:if>

            <form:errors path="name" element="span" />
            <div class="form-group">
                <form:input path="name" type="text" placeholder="Nazwa fundacji" />
            </div>

            <form:errors path="description" element="span" />
            <div class="form-group">
                <form:input path="description" type="text" placeholder="Opis fundacji" />
            </div>

            <%--            <div class="form-group">--%>
            <%--                <form:input path="password" type="password" placeholder="Hasło" />--%>
            <%--                <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>--%>
            <%--            </div>--%>

            <div class="form-group form-group--buttons">
                <a href="<c:url value="/admin/institutions"/>" class="btn btn--without-border">Powrót do listy</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn" type="submit">Aktualizuj fundację</button>
            </div>
        </form:form>
    </div>

</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>