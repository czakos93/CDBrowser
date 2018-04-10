<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wykonawcy</title>
</head>
<body>
	<h1>Wszyscy wykonawcy</h1>
	<div>
		<c:forEach items="${artists}" var="artist">
			<div>
				<div><img src=""/></div>
				<h2>${artist.name}</h2>
				<p>Liczba albumów:<a href="">pokaż</a></p>
				
			</div>
		</c:forEach>
	</div>
</body>
</html>