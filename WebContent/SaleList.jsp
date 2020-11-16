<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
<div id="wrap">
		<br>
		<br> <b><font size="6" color="gray">판매목록</font></b> <br>
		<br>
		<br>

		<table>
			<tr>
				<td>판매번호</td>
				<td>구매자</td>
				<td>상품번호</td>
				<td>상품이름</td>
				<td>사이즈</td>
				<td>구매수량</td>
				<td>구매가격</td>
				<td>구매일</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="sale" items="${salelist}">
				<tr>
					<td>${sale.bnum}</td>
					<td>${sale.bmid}</td>
					<td>${sale.bpid}</td>
					<td>${sale.bpname}</td>
					<td>${sale.bsize}</td>
					<td>${sale.bquantity}</td>
					<td>${sale.bpprice}</td>
					<td>${sale.bdate}</td>
					<td><a href="#">삭제</a>
				</tr>
			</c:forEach>
		</table>

		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>

		<c:if test="${paging.page>1}">
			<a href="salelist?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
			</c:when>
				<c:otherwise>
					<a href="salelist?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

		<c:if test="${paging.page<paging.maxPage}">
			<a href="salelist?page=${paging.page+1}">[다음]</a>
		</c:if>
		<br> <a href="Admin.jsp">관리자페이지</a>

	</div>

</body>
</html>