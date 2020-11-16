<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	margin: 0;
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

* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial;
	font-size: 17px;
}

#myVideo {
	position: absoute;
	top: 0px;
	left: 0px;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: auto;
	z-index: -1000;
	overflow: hidden;
}

.content {
	position: fixed;
	bottom: 0;
	background: rgba(0, 0, 0, 0.5);
	color: #f1f1f1;
	width: 100%;
	padding: 20px;
}

#myBtn {
	width: 200px;
	font-size: 18px;
	padding: 10px;
	border: none;
	background: #000;
	color: #fff;
	cursor: pointer;
}

#myBtn:hover {
	background: #ddd;
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

	<video autoplay muted loop id="myVideo">
		<source src="광고.mp4" type="video/mp4">
		<source src="광고.webm" type="video/webm">

	</video>

	<div class="content">
		<h1>NICE</h1>
		<button id="myBtn" onclick="myFunction()">Pause</button>
	</div>

	<script>
		var video = document.getElementById("myVideo");
		var btn = document.getElementById("myBtn");

		function myFunction() {
			if (video.paused) {
				video.play();
				btn.innerHTML = "Pause";
			} else {
				video.pause();
				btn.innerHTML = "Play";
			}
		}
	</script>
</body>
</html>