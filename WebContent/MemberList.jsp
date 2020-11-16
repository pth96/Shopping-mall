<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
         #wrap{
            width:530px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
        
        table{
            border:3px solid skyblue;
        }
        
        td{
            border:1px solid skyblue;
            text-align:left;
            
        }
        
        #title{
            background-color:skyblue;
            text-align:center;
       
        }
    </style>
</head>
<body>
<div id="wrap">
        <br><br>
        <b><font size="6" color="gray">회원목록</font></b>
        <br><br><br>
        
            <table>
                <tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>주소</td>
			<td>휴대폰번호</td>
			<td>이메일</td>
		</tr>
         <c:forEach var="member" items="${memberlist}" >
			<tr>
				<td>${member.mid}</td>
				<td>${member.mname}</td>
				<td>${member.mbirth}</td>
				<td>${member.malladdress}</td>
				<td>${member.mphone}</td>
				<td>${member.memail}</td>
			</tr>
		</c:forEach>           
            </table>
            <!-- 페이징 처리 -->
	<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	
	<c:if test="${paging.page>1}">
		<a href="memberlist?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
			</c:when>
			<c:otherwise>
				<a href="memberlist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxPage}">
		[다음]
	</c:if>
	
	<c:if test="${paging.page<paging.maxPage}">
		<a href="memberlist?page=${paging.page+1}">[다음]</a>
	</c:if>

    </div>

</body>
</html>