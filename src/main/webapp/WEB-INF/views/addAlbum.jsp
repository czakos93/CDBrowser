<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form:form modelAttribute="newAlbum" enctype="multipart/form-data">
			<fieldset>				
				<legend>Dodaj album</legend>
				<div>
					<label>Tytuł</label>
					<form:input path="title" type="text" /><br />
					<label>Wykonawca</label>
					<form:select path="artist.id" >
						<form:options items="${artists}" itemValue="id" itemLabel="name" />
					</form:select>
					<label>Data premiery</label>
					<form:input path="releaseDate" type="date"/><br/>
					<form:input path="cover" type="file"/>
					<input type="submit" value="Dodaj"/>					
				</div>
			</fieldset>
		</form:form>

	</div>
</body>
</html>