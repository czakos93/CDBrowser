<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edytuj ${albumToUpdate.title }</title>
</head>
<body>
<div>
		<form:form modelAttribute="albumToUpdate" enctype="multipart/form-data">
			<fieldset>				
				<legend>Edytuj album: ${albumToUpdate.title }/${albumToUpdate.artist }</legend>
				<div>
					
					<label>Tytuł</label>
					<form:input path="title" type="text" />
					<label>Wykonawca</label>
					<form:input path="artist" type="text"/>
					<form:input path="albumImage" type="file" class="form:input-large"/>					
					<input type="submit" value="Edytuj"/>

				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>