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
	left: 43%;
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

.page {
	width: 500px;
	position: relative;
	left: 59%;
	margin-left: -250px;
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
	<c:set var="j" value="2" />
	<c:forEach var="serch" items="${listserch}">
		<c:if test="${i%j == 0 }">
			<br>
		</c:if>
		<div class="main">
			<a href="productview?pid=${serch.pid}"><img
				src="Uploadfile/${serch.pfilename}" width="200" height="200"></a>
			<br> <a href="productview?pid=$serch.pid}">${serch.pname}</a>
			<br> ${serch.pprice}원<br>
		</div>
		<c:if test="${i%j == j-1 }">
			<br>
		</c:if>
		<c:set var="i" value="${i+1 }" />

	</c:forEach>
	<br>

	<!-- 페이징 처리 -->
	<div class="page">
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>

		<c:if test="${paging.page>1}">
			<a href="listserch?page=${paging.page-1}&keyword=${keyword}">[이전]</a>&nbsp;
	</c:if>

		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
			</c:when>
				<c:otherwise>
					<a href="listserch?page=${i}&keyword=${keyword}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

		<c:if test="${paging.page<paging.maxPage}">
			<a href="listserch?page=${paging.page+1}&keyword=${keyword}">[다음]</a>
		</c:if>
	</div>

</body>
</html>