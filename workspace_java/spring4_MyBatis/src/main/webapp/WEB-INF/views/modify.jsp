<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>
<hr>
<form method="post" action="/modify">
	empno: ${empDTO.empno }<br>
	<input type="hidden" name="empno" value="${empDTO.empno }">
	ename: <input type="text" name="ename" value="${empDTO.ename }"><br>
	job: <input type="text" name="job" value="${empDTO.job }"><br>
	sal: <input type="number" name="sal" value="${empDTO.sal }"><br>
	mgr: <input type="text" name="mgr" value="${empDTO.mgr }"><br>
	hiredate: <input type="date" name="hiredate" value="${empDTO.hiredate }"><br>
	comm: <input type="text" name="comm" value="${empDTO.comm }"><br>
	deptno: <input type="text" name="deptno" value="${empDTO.deptno }"><br>
	<input type="submit" value="수정완료">
	<a href="/list"><input type="button" value="취소"></a>
</form>

</body>
</html>