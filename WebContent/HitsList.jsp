<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
}

/* Header/Blog Title */
.header {
	padding: 30px;
	text-align: center;
}

.header h1 {
	font-size: 50px;
	clolr: black;
}

.header a:hover {
	background-color: #ddd;
	color: black;
}

.header a {
	text-decoration: none;
	color: black;
	padding: 5px;
}

.nav {
	text-align: center;
	overflow: hidden;
}

.nav a {
	padding: 14px 14px;
	text-decoration: none;
	color: black;
	font-size: 20px;
}

.nav0 {
	float: right;
}

.nav0 a {
	text-decoration: none;
	color: black;
	padding: 5px;
}

.nav a:hover {
	background-color: #ddd;
	color: black;
}

.nav0 a:hover {
	background-color: #ddd;
	color: black;
}

.nav1 {
	float: left;
}

.nav1 a:hover {
	background-color: #ddd;
	color: black;
}

.nav1 a {
	text-decoration: none;
	color: black;
	padding: 5px;
}

.main {
	width: 500px;
	padding: 20px;
	text-align: center;
	position: relative;
	left: 30%;
	margin-left: -250px;
	display: inline-block;
	position: relative;
}

.main a {
	text-decoration: none;
	color: black;
}

.main a:hover {
	background-color: #ddd;
	color: black;
}


</style>
<script>
	function listserch(){
		var keyword = document.getElementById("keyword").value;
		 location.href="listserch?keyword="+keyword;
	}
</script>
</head>
<body>
<div class="nav1">
		<c:if test="${sessionScope.loginId eq 'admin'}">
			<a href="Admin.jsp">관리자</a>
		</c:if>
		<c:if test="${loginId != null}">
			<a href="memberview?mid=${sessionScope.loginId}">내정보</a>
		</c:if>
	</div>
	<div class="nav0">
		<c:if test="${loginId == null}">
			<a href="MemberLogin.jsp">로그인</a>
			<a href="MemberJoin.jsp">회원가입</a>
		</c:if>
		<c:if test="${loginId != null}">
    ${sessionScope.loginId} 님 환영합니다.
    <a href="memberlogout">로그아웃</a>
		</c:if>
		<c:choose>
			<c:when test="${loginId != null}">
				<a href="cartlist?mid=${sessionScope.loginId}">장바구니</a>
			</c:when>
			<c:otherwise>
				<a href="MemberLogin.jsp">장바구니</a>
			</c:otherwise>

		</c:choose>
	</div>
	<br>

	<div class="header">
		<h1>
			<a href="Main.jsp">NICE</a>
		</h1>
		<input type="text" id="keyword">
		<button onclick="listserch()">검색</button>
	</div>

	<div class="nav">
		<a href="hitslist">Best</a> <a href="productlist?pgender=MAN">Men</a> <a
			href="productlist?pgender=WOMAN">Woman</a> <a
			href="productlist?pgender=KIDS">Kids</a>
	</div>


	<c:set var="i" value="0" />
	<c:set var="j" value="4" />
	<c:forEach var="hits" items="${hitslist}">
		<c:if test="${i%j == 0 }">
			<br>
		</c:if>
		<div class="main">
			<a href="productview?pid=${hits.pid}"><img
				src="Uploadfile/${hits.pfilename}" width="200" height="200"></a>
			<br> <a href="productview?pid=${hits.pid}">${hits.pname}</a>
			<br> ${hits.pprice}원<br>
		</div>
		<c:if test="${i%j == j-1 }">
			<br>
		</c:if>
		<c:set var="i" value="${i+1 }" />

	</c:forEach>

</body>
</html>