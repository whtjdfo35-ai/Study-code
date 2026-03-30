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
<c:set var="a" value="10"></c:set>
<!-- 다른 영역(리퀘스트)에 넣을 수 있다 -->
<!-- 서버에 변수를 저장함 -->

\${a} : ${a}<br>
<%
	String name = "tjdfo";
%>
\${name } : ${name }<br>
<input value="<%=name %>">

<c:set var="name2" value="<%= name %>"/>
\${name2 } : ${name2 }<br>

scope: page > request > session > application<br>
<!-- page: 현재 페이지에서만 사용하는지역변수
	request: response전까지만. forward의 경우에 살아있음
	session: session을 공유하는 곳= 같은 로그인 공유 ex)같은 브라우저
	application: 서버에 변수가 살아있지만 접점이 없는 곳에서 나옴-다른 브라우저,스크릿모드 등
 -->
<c:set var="name3" value="<%=name %>" scope="page"></c:set>
scope 생략하면 page<br>

<c:set var="wish" value="date" scope="page"/>
<c:set var="wish" value="trip" scope="request"/>
<c:set var="wish" value="game" scope="session"/>
<c:set var="wish" value="sleep" scope="application"/>
\${wish }: ${wish }<br>

pageScope: ${pageScope.wish }<br>
requestScope: ${requestScope.wish }<br>
sessionScope: ${sessionScope.wish }<br>
applicationScope: ${applicationScope.wish }<br>


<%-- <jsp:forward page="jstl_5_1_scope.jsp"/> --%>

<hr>

<c:if test="true"/>
	always true<br>

<c:set var="b" value="100"/>
<c:if test="${b >10 }" >
b is larger than 10<br>
</c:if>
<%-- <c:if .... /> 쓰면 안됨 </c:if>로 닫아야함 --%>

<c:if test="${b eq 100 }" >
b is equals 100<br>
</c:if>

<c:if test="${not (b eq 100) }" >
b is not equals 100<br>
</c:if>

<c:choose>
	<c:when test="${b eq 99 }">
		b is 99<br>
	</c:when>
	<c:when test="${b eq 100 }">
		b is 100<br>
	</c:when>
	<c:otherwise>
		b is not only 99 but also 100<br>
	</c:otherwise>
</c:choose>

<hr>

<%
	List list = new ArrayList();
	for(int i=15; i<20; i++){
		Map map = new HashMap();
		map.put("정신연령",i);
		map.put("실제나이",i+10);
		
		list.add(map);
	}
%>

<c:set var="list2" value="<%= list %>" scope="page"/>
첫번째 목록의 실제 나이: ${ list2[0].실제나이}<br>

<br>
items<br>
<%-- <c:forEach var="m" items="<%= list %>"> --%>
<c:forEach var="m" items="${list2}">
	정신연령: ${m.정신연령 }<br>
	실제나이: ${m.실제나이 }<br>
</c:forEach>

<hr>
begin, end <br>

<c:forEach var="i" begin="0" end="3">
	${i }, ${list2[i].정신연령 }<br>
</c:forEach>

<c:forEach var="i" begin="0" end="${list2.size()-1 }">
	${i }, ${list2[i].정신연령 }<br>
</c:forEach>

<hr>
step<br>
<c:forEach var="i" begin="0" end="10" step="2">
	${i }, ${list2[i].정신연령 }<br>
</c:forEach>

<hr>
varStatus<br>
<c:forEach var="i" begin="0" end="4" step="2" varStatus="loop">
	${i }, ${list2[i].정신연령 }<br>
	loop.index : ${loop.index }<br>
	loop.count : ${loop.count }<br>
	loop.first : ${loop.first }<br>
	loop.last : ${loop.last }<br>
	<c:if test="${not loop.last}">
		@<br>
	</c:if>
	
</c:forEach>

<hr>
items, begin<br>
<c:forEach var="m" items="${list2 }" begin="1" end="3">
	${m}, ${m.실제나이 }<br>
</c:forEach>

<hr>
<c:forEach var="list" items="${list}">
	정신연령: ${list.정신연령 }<br>
	실제나이: ${list.실제나이 }<br>
</c:forEach>


<c:forEach var="m" begin="2" end="9" >
	<c:if test="${not (m eq 3) && not (m eq 7)}">		
		<c:forEach var="l" begin="1" end="9">
			${m }x${l } =${m*l } <br>
		</c:forEach>
		<br>		
	</c:if>	
</c:forEach>

<hr>

c:url 사용 이유<br>
1. context path를 자동으로 추가<br>
<c:url var="url1" value="/el_4.jsp">
</c:url>
<a href="${url1 }" target="_blank">el_4.jsp</a> <br>

2. url인코딩<br>
<c:url var="url2" value="https://search.naver.com/search.naver">
	<c:param name="query" value="한글"/>
</c:url>
<a href="${url2 }" target="_blank">naver</a> <br>

3. 쿠키 금지일때 ";jsessionid=blahblah"를 자동으로 붙여줌

<hr>
c:out<br>
param.html : ${param.html } : innerHTML <br>
c:out : <c:out value="${param.html  }"/> : innerText <br>

<!-- < : &lt; -->
<!-- > : &gt; -->
<!-- 공백 :  &nbsp; -->
<!-- & : &amp; -->

</body>
</html>