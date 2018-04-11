<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Logowanie</title>
	</head>
	<body>
	
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="msg">${message}</div>
		</c:if>
		
		<div>
			<form name='loginForm' method='POST'  action="login">
				<div>
					<label>Nazwa użytkowanika</label>
					<input type='text' name='username' value=''/>
				</div>	
				<div>
					<label>Hasło</label>
					<input type='password' name='password' value=''/>
				</div>
				<div><input type='submit' name='submit' value='Zaloguj'/></div>
				<input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<div><a href="<c:url value="/user/registration"/>">Załóż</a></div>
	</body>
</html>