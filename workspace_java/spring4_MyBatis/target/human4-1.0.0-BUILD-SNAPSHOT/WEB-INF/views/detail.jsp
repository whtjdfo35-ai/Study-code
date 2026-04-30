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
empno:${empDTO.empno }<br>
ename: ${empDTO.ename }<br>
job: ${empDTO.job }<br>
sal: ${empDTO.sal }<br>
mgr: ${empDTO.mgr }<br>
hiredate: ${empDTO.hiredate }<br>
comm: ${empDTO.comm }<br>
deptno: ${empDTO.deptno }<br>
<hr>
<a href="modify/${empDTO.empno }">
	<button type="button">수정</button>
</a>
<button type="button" id="btnDel">삭제</button>
<a href="list">
	<button type="button">목록으로</button>
</a>

<script>
	const empno = '${empDTO.empno }'
	document.querySelector('#btnDel').addEventListener('click', ()=>{
		let param = {
			empno: empno
		}
		fetch('delete', {
			method: 'POST',
			headers:{
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(resp => resp.text())
		.then(text => {
			if(text == 'Y'){
				location.href="/list"
			} else {
				alert('삭제하지 못했습니다.\n관리자에게 문의하세요')
			}
		})
	})	
</script>
</body>
</html>