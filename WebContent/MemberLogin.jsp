<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #wrap{
            width:300px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
        
        table{
            border:3px solid skyblue;
            
        }
        
        td{
            border:1px solid skyblue;
          
            
        }
        
        #title{
            background-color:skyblue;
         
       
        }
        
    </style>
<script>
  function goLogin(){
	  loginform.submit();
  }
  function goJoin(){
	  location.href ="MemberJoin.jsp";
  }
  </script>
</head>
<body>
<div id="wrap">
        <br><br>
        <b><font size="6" color="gray">로그인</font></b>
        <br><br><br>
        
        <form action="memberlogin" method="post" name="loginform">
            <table>
                <tr>
                    <td id="title">아이디</td>
                    <td>
                     <input type="text" name="mid" id="mid">
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">비밀번호</td>
                    <td>
                        <input type="password" name="mpassword" id="mpassword">                   
                    </td>
                </tr>
                 </table>           
        </form>
            <button onclick="goLogin()">로그인</button>
            <button onclick="goJoin()">회원가입</button>
    
        
    </div>

</body>
</html>