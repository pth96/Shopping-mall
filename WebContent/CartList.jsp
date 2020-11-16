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
	text-align: center;
}

#title {
	background-color: skyblue;
	text-align: center;
}
</style>
<script>
      function cartalldelete(){
    	  location.href="cartalldelete";
      }
      function listserch(){
  		var keyword = document.getElementById("keyword").value;
  		 location.href="listserch?keyword="+keyword;
  	}
      function buy1(){
    	  var mpoint = document.getElementById("mpoint").value;
    	  
    	  var total = document.getElementById("total").value;
    	  mpoint = parseInt(mpoint);
    	  total = parseInt(total);
  
    	  if(total > 0){
    		  if(mpoint >= total){
        		  cartbuyform.submit();
        		  alert("구매완료");
    		  }
    		  else{
    			alert("잔액이부족합니다");
    		  }
    		 
    	  }
    		 
    		  
    	  
    		 
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
	<div id="wrap">
		<br>
		<br> <b><font size="6" color="gray">장바구니</font></b> <br>
		<br>
		<br>
		<form action="cartbuy" method="post" name="cartbuyform">
			<table>
				<tr>
					<th>삭제</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>사이즈</th>
					<th>상품가격</th>
					<th>구매수량</th>
					<th>총금액</th>
				</tr>
				<c:set var="total" value="0" />
				<c:forEach var="cart" items="${cartlist}">
					<input type="hidden" name="mid" id="mid" value="${cart.mid}">
					<input type="hidden" name="pid" id="pid" value="${cart.pid}">
					<input type="hidden" name="pfilename" id="pfilename"
						value="${cart.cpfilename}">
					<input type="hidden" name="pname" id="pname" value="${cart.pname}">
					<input type="hidden" name="psize" id="psize" value="${cart.cpsize}">
					<input type="hidden" name="pprice" id="pprice"
						value="${cart.pprice}">
					<input type="hidden" name="pbnum" id="pbnum" value="${cart.cpbnum}">
					<input type="hidden" name="cpprice" id="cpprice"
						value="${cart.cpprice}">
					<input type="hidden" name="mpoint" id="mpoint" value="${cart.mpoint}">
					<tr>
						<td><a href="cartdelete?pid=${cart.pid}">X</a></td>
						<td><img src="Uploadfile/${cart.cpfilename}" width="150"
							height="150"></td>
						<td>${cart.pname}</td>
						<td>${cart.cpsize}</td>
						<td>${cart.pprice}원</td>
						<td>${cart.cpbnum}EA</td>
						<td>${cart.cpprice}원</td>
					</tr>
					<c:set var="total" value="${total+cart.cpprice}" />
				</c:forEach>
			</table>
			총 구매금액 : ${total} <input type="hidden" name="total" id="total"
				value="${total}">
		</form>
		<button onclick="buy1()">구매</button>
		<button onclick="cartalldelete()">장바구니 비우기</button>

	</div>

</body>
</html>