<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		border: 1px solid red;
		margin: 10px;
		padding: 10px;
	}
</style>
</head>
<body>
<div>
	<form method=get action="getEmpno">
		empno : <input type=text name=empno>
		<input type=submit value="empno 검색">
	</form>
</div>
<div>
	<form method=get action="getEname">
		ename : <input type=text name=ename>
		<input type=submit value="ename 검색">
	</form>
</div>
<div>
	<form method=get action="getJob">
		job : <input type=text name=job>
		<input type=submit value="job 검색">
	</form>
</div>
<div>
	<form method=get action="getJobEname">
		job : <input type=text name=job><br>
		ename : <input type=text name=ename><br>
		<input type=submit value="job 검색">
	</form>
</div>
</body>
</html>