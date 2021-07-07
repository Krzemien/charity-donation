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
    <h2></h2>

    <c:forEach items="${donations}" var="donation">
        <div class="help--slides active">
            <div>
                <p>ID: ${donation.id}</p>
                <p>Worki: ${donation.quantity}</p>
                <p>Ulica: ${donation.street}</p>
                <p>Miasto: ${donation.city}</p>
                <p>Kod pocztowy: ${donation.zipCode}</p>
                <p>Telefon: ${donation.phoneNumber}</p>
                <p>Data i godzina odbioru: ${donation.pickUpDate}, ${donation.pickUpTime}</p>
                <p>Komentarz: ${donation.pickUpComment}</p>
            </div>
        </div>
    </c:forEach>

</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>