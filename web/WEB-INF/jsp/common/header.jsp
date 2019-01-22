<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<c:url value="/styles/style.css" var="cssUrl"/>
<link rel="stylesheet" type="text/css" href="${cssUrl}"/>
<title>Oyaba Dog Store: ${pageTitle}</title>
</head>
<body>
<div id="header">
    <div class="username">
	Welcome, 
        <sec:authorize access="isAuthenticated()">
            <strong>
                <sec:authentication property="principal.username"/>
            </strong>
        </sec:authorize>
    </div>
    <ul>
	<c:url value="/" var="homeUrl"/>
	<li><a href="${homeUrl}">Home</a></li>
        <%--
	<c:url value="/j_spring_security_logout" var="logoutUrl"/>
	<li><a href="${logoutUrl}">Log Out</a></li>
        --%>
 	<c:url value="/j_spring_security_logout" var="logoutUrl"/>
	<li><a href="${logoutUrl}">Log Out</a></li>

	<c:url value="home.htm" var="accountUrl"/>
	<li><a href="${accountUrl}">My Account</a></li>

	<c:url value="home.htm" var="wishlistUrl"/>
	<li><a href="${wishlistUrl}">My Wishlist</a></li>
    </ul>
<br />
</div>

