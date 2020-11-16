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
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	border: 3px solid skyblue;
}

td {
	border: 1px solid skyblue;
	text-align: left;
}

#title {
	background-color: skyblue;
	text-align: center;
}
</style>
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
<div id="wrap">
		<br>
		<br> <b><font size="6" color="gray">구매목록</font></b> <br>
		<br>
		<br>

		<table>
			<tr>
				<td>주문번호</td>
				<td>상품이미지</td>
				<td>상품코드</td>
				<td>상품이름</td>
				<td>사이즈</td>
				<td>구매수량</td>
				<td>구매가격</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="buy" items="${buylist}">
				<tr>
					<td>${buy.bnum}</td>
					<td><img src="Uploadfile/${buy.bfilename}" width="150"
							height="150"></td>
				    <td>${buy.bpid}</td>
					<td>${buy.bpname}</td>
					<td>${buy.bsize}</td>
					<td>${buy.bquantity}</td>
					<td>${buy.bpprice}</td>	
					<td><a href="buycancel?bnum=${buy.bnum}&bquantity=${buy.bquantity}&bpprice=${buy.bpprice}&bpid=${buy.bpid}">구매취소</a>
				</tr>
			</c:forEach>
		</table>

		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>

		<c:if test="${paging.page>1}">
			<a href="buylist?page=${paging.page-1}&mid=${mid}">[이전]</a>&nbsp;
	</c:if>

		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
			</c:when>
				<c:otherwise>
					<a href="buylist?page=${i}&mid=${mid}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

		<c:if test="${paging.page<paging.maxPage}">
			<a href="buy?page=${paging.page+1}&mid=${mid}">[다음]</a>
		</c:if>
		

	</div>


</body>
</html>