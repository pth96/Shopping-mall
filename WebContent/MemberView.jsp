<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script>

</script>
</head>
<body>

 <div id="wrap">
        <br><br>
        <b><font size="6" color="gray">내정보</font></b>
        <br><br><br>
        
            <table>
                <tr>
                    <td id="title">아이디</td>
                    <td>
                       ${memberview.mid} 
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">이름</td>
                    <td>
                        ${memberview.mname}                   
                    </td>
                </tr>
                
                <tr>
                    <td id="title">생년월일</td>
                    <td>
                        ${memberview.mbirth}
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">주소</td>
                    <td>
                        ${memberview.malladdress}
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">휴대폰번호</td>
                    <td>
                        ${memberview.mphone}
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">이메일</td>
                    <td>
                        ${memberview.memail}
                    </td>
                </tr>
                <tr>
                    <td id="title">잔액</td>
                    <td>
                        ${memberview.mpoint}원
                    </td>
                </tr>
                    
            </table>
            <button onclick="location.href='memberupdate'">수정하기</button>
            <button onclick="location.href='buylist'">구매내역</button>
            <button onclick="location.href='memberdelete'">회원탈퇴</button>
      
       
    </div>

</body>
</html>