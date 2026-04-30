<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
<a href="join.do">가입</a>
<hr>
<form method=get action="search">

<%-- 	이름: <input type="text" name="ename" value="${empDTO.ename }"> --%>
<%-- 	월급: <input type="number" name="sal" value="${empDTO.sal }"> --%>

	<select name="type">
		<option value="ename" <c:if test='${empDTO.type eq "ename"}'> selected="selected" </c:if>>ename</option>
		<option value="sal" ${empDTO.type eq "sal" ? 'selected="selected"' : ''}>sal(이상)</option>
		<option value="job" ${empDTO.type eq "job" ? 'selected="selected"' : ''}>job</option>
	</select>
	<input type="text" name="keyword" value="${empDTO.keyword }">

	<input type="submit" value="검색">
</form>
<hr>
<form method="get" action="choice">
<table border=1>
	<thead>
		<tr>
			<th>선택</th>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>sal</th>
			<th>mgr</th>
			<th>hiredate</th>
			<th>comm</th>
			<th>deptno</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty list }">
			<c:forEach var="dto" items="${list}">
			<tr>
				<td>
					<input type="checkbox" name="empnos" value="${dto.empno}">
				</td>
				<td>${dto.empno }</td>
				<td>
					<a href="detail?empno=${dto.empno }">${dto.ename }</a>
				</td>
				<td>${dto.job }</td>
				<td>${dto.sal }</td>
				<td>${dto.mgr }</td>
				<td>${dto.hiredate }</td>
				<td>${dto.comm }</td>
				<td>${dto.deptno }</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			<tr>
				<td>${empDTO.empno }</td>
				<td>
					<a href="detail?empno=${dto.empno }">${dto.ename }</a>
				</td>
				<td>${empDTO.job }</td>
				<td>${empDTO.sal }</td>
				<td>${empDTO.mgr }</td>
				<td>${empDTO.hiredate }</td>
				<td>${empDTO.comm }</td>
				<td>${empDTO.deptno }</td>
			</tr>
		</c:if>
	</tbody>
</table>
<input type="submit" value="선택 조회">
</form>
</body>
</html>