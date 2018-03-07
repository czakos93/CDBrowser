<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Albums</title>
</head>
<body>
	<div>
		<c:forEach items="${albums}" var="album">
			<div>${album.title}</div>
			<div>${album.artist}</div>
			<div>${album.albumId}</div>
		</c:forEach>
	</div>
</body>
</html>