<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
    <jsp:include page="nav.jsp"></jsp:include>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Oddaj rzeczy, których już nie chcesz<br />
                <span class="uppercase">potrzebującym</span>
            </h1>

            <div class="slogan--steps">
                <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                <ul class="slogan--steps-boxes">
                    <li>
                        <div><em>1</em><span>Wybierz rzeczy</span></div>
                    </li>
                    <li>
                        <div><em>2</em><span>Spakuj je w worki</span></div>
                    </li>
                    <li>
                        <div><em>3</em><span>Wybierz fundację</span></div>
                    </li>
                    <li>
                        <div><em>4</em><span>Zamów kuriera</span></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<%--<form:form method="post" modelAttribute="donation">--%>
<%--    <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" />--%>

<%--    <form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id" />--%>

<%--    <form:input path="quantity" />--%>
<%--    <form:errors path="quantity" />--%>

<%--    <form:input path="street" />--%>
<%--    <form:errors path="street" />--%>

<%--    <form:input path="city"/>--%>
<%--    <form:input path="city"/>--%>

<%--    <form:input path="zipCode" />--%>
<%--    <form:errors path="zipCode" />--%>

<%--    <form:input type="date" path="pickUpDate"/>--%>
<%--    <form:errors path="pickUpDate" />--%>

<%--    <form:input type="time" path="pickUpTime" />--%>
<%--    <form:errors path="pickUpTime" />--%>

<%--    <form:textarea path="pickUpComment"/>--%>
<%--    <form:errors path="pickUpComment" />--%>

<%--    <input type="submit" value="test">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--</form:form>--%>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <c:if test="${not empty info}">
            <div class="form--steps-counter">
                <span>${info}</span>
            </div>
        </c:if>

<%--        <form action="form-confirmation.html" method="post">--%>
        <form:form method="post" modelAttribute="donation">

            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach var="category" items="${categories}">
                <div class="form-group form-group--checkbox">
                    <label>
<%--                        <form:checkbox path="categories" value="${category.id}" />--%>
                        <input type="checkbox" value="${category.id}" name="categories" title="${category.name}">
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
                </c:forEach>

                <form:errors path="categories" element="span" />

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input--%>
<%--                                type="checkbox"--%>
<%--                                name="categories"--%>
<%--                                value="clothes-to-use"--%>
<%--                        />--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description"--%>
<%--                        >ubrania, które nadają się do ponownego użycia</span--%>
<%--                        >--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input--%>
<%--                                type="checkbox"--%>
<%--                                name="categories"--%>
<%--                                value="clothes-useless"--%>
<%--                        />--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">ubrania, do wyrzucenia</span>--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="checkbox" name="categories" value="toys" />--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">zabawki</span>--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="checkbox" name="categories" value="books" />--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">książki</span>--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="checkbox" name="categories" value="other" />--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">inne</span>--%>
<%--                    </label>--%>
<%--                </div>--%>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
<%--                        <input type="number" name="bags" step="1" min="1" />--%>
                        <form:input path="quantity" />
                        <form:errors path="quantity" element="span" />
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <c:forEach var="institution" items="${institutions}">
                    <div class="form-group form-group--checkbox">
                        <label>
<%--                            <form:checkbox path="institution" value="${institution.id}" />--%>
                            <input type="radio" value="${institution.id}" name="institution" title="${institution.name}">
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title">Fundacja “${institution.name}”</div>
                                <div class="subtitle">
                                    Cel i misja: ${institution.description}
                                </div>
                            </span>
                        </label>
                    </div>
                </c:forEach>
                <form:errors path="institution" element="span" />

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="radio" name="organization" value="old" />--%>
<%--                        <span class="checkbox radio"></span>--%>
<%--                        <span class="description">--%>
<%--                  <div class="title">Fundacja “Bez domu”</div>--%>
<%--                  <div class="subtitle">--%>
<%--                    Cel i misja: Pomoc dla osób nie posiadających miejsca--%>
<%--                    zamieszkania--%>
<%--                  </div>--%>
<%--                </span>--%>
<%--                    </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <input type="radio" name="organization" value="old" />--%>
<%--                        <span class="checkbox radio"></span>--%>
<%--                        <span class="description">--%>
<%--                  <div class="title">Fundacja “Dla dzieci"</div>--%>
<%--                  <div class="subtitle">--%>
<%--                    Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji--%>
<%--                    życiowej.--%>
<%--                  </div>--%>
<%--                </span>--%>
<%--                    </label>--%>
<%--                </div>--%>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>
                                Ulica
<%--                                <input type="text" name="address" />--%>
                                <form:errors path="street" element="span" />
                                <form:input path="street" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Miasto
<%--                                <input type="text" name="city" />--%>
                                <form:errors path="city" element="span" />
                                <form:input path="city" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy
<%--                                <input type="text" name="postcode" />--%>
                                <form:errors path="zipCode" element="span" />
                                <form:input path="zipCode" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu
<%--                                <input type="phone" name="phone" />--%>
                                <form:errors path="phoneNumber" element="span" />
                                <form:input path="phoneNumber" />
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label>
                                Data
<%--                                <input type="date" name="data" />--%>
                                <form:errors path="pickUpDate" element="span" />
                                <form:input path="pickUpDate" type="date" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Godzina
<%--                                <input type="time" name="time" />--%>
                                <form:errors path="pickUpTime" element="span" />
                                <form:input path="pickUpTime" type="time" />
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
<%--                                <textarea name="more_info" rows="5"></textarea>--%>
                                <form:errors path="pickUpComment" element="span" />
                                <form:textarea path="pickUpComment" rows="5" />
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                    <span id="quantityValue"></span> worki
                                    <span id="categoriesValue"></span>
                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">
                                    Dla fundacji "<span id="institutionValue"></span>"
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li><span id="streetValue"></span></li>
                                <li><span id="cityValue"></span></li>
                                <li><span id="zipCodeValue"></span></li>
                                <li><span id="phoneNumberValue"></span></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li><span id="pickUpDateValue"></span></li>
                                <li><span id="pickUpTimeValue"></span></li>
                                <li><span id="pickUpCommentValue"></span></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
<%--        </form>--%>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
