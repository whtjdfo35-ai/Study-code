<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="user" items="${userList}">
		<p>${user.id}/${user.pw}</p>
	</c:forEach>
	
	<div>
		id : <input type="text"> <br>
		pw : <input type="password">
	</div>
	<button type="submit">가입</button>
	
</body>
</html>