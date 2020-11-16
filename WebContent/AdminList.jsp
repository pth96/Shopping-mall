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
		<br> <b><font size="6" color="gray">회원목록</font></b> <br>
		<br>
		<br>

		<table>
			<tr>
				<td>상품코드</td>
				<td>상품이름</td>
				<td>상품가격</td>
				<td>상품성별</td>
				<td>상품수량</td>
				<td>상품등록일</td>
				<td>상품조회수</td>
				<td>조회</td>
				<td>삭제</td>
			</tr>
			<c:forEach var="admin" items="${adminlist}">
				<tr>
					<td>${admin.pid}</td>
					<td>${admin.pname}</td>
					<td>${admin.pprice}</td>
					<td>${admin.pgender}</td>
					<td>${admin.pquantity}</td>
					<td>${admin.pdate}</td>
					<td>${admin.phits}</td>
					<td><a href="productupdate?pid=${admin.pid}">수정</a>
					<td><a href="#">삭제</a>
				</tr>
			</c:forEach>
		</table>

		<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>

		<c:if test="${paging.page>1}">
			<a href="adminlist?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
			${i}
			</c:when>
				<c:otherwise>
					<a href="adminlist?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>

		<c:if test="${paging.page<paging.maxPage}">
			<a href="adminlist?page=${paging.page+1}">[다음]</a>
		</c:if>
		<br> <a href="Admin.jsp">관리자페이지</a>

	</div>


</body>
</html>