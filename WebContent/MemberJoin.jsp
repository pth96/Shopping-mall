<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
function pwdeqFn(){
    var pwd= document.getElementById("mpassword").value;
    var pwdch= document.getElementById("mpasswordch").value;
    var epmsg = document.getElementById("pwdEq");
    if(pwd==pwdch){
      epmsg.style.color = "blue";
      epmsg.innerHTML="비밀번호 일치"
      
      
    }else{
      epmsg.style.color = "red";
      document.getElementById("pwdEq").innerHTML="비밀번호 불일치";
    }

  }
function pwdCheck(){
    //비밀번호를 위한 정규식
    //소문자,대문자,숫자,특수문자가 포함되고 자릿수는 8~16자리 정규식
    var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
    var pwd = document.getElementById("mpassword").value;
    var pwdch = document.getElementById("pwdch");
    if(pwd.match(exp)){
      pwdch.style.color = "blue";
      pwdch.innerHTML = "비밀번호 사용가능";
    }else{
    	pwdch.style.color = "red";
      pwdch.innerHTML = "비밀번호 사용불가";
    }
    }
 function idCheck(){
	 var exp = /^[A-Za-z0-9+]*$/;
	 var id = document.getElementById("mid").value;
	 var idch = document.getElementById("idch");
	 if(id.match(exp)){
		 idch.style.color = "blue";
		 idch.innerHTML = "아이디 사용가능";
	 }else{
		 idch.style.color = "red";
		 idch.innerHTML = "영문 순자만 입력가능합니다";
	 }
	 }
 function phoneCheck(){
	 var exp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	 var phone = document.getElementById("mphone").value;
	 var phonech = document.getElementById("phonech");
	 if(phone.match(exp)){
		 phonech.style.color = "blue";
		 phonech.innerHTML = "O";
	 }else{
		 phonech.style.color = "red";
		 phonech.innerHTML = "입력하신 번호 확인바랍니다.";
	 }
	 
 }
 function join(){
	 joinform.submit;
 }
 </script>
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
     function join(){
    	 joinform.submit();
    	 
     }
	function listserch(){
		var keyword = document.getElementById("keyword").value;
		 location.href="listserch?keyword="+keyword;
	}
</script>
</head>
<body>
 <div id="wrap">
        <br><br>
        <b><font size="6" color="gray">회원가입</font></b>
        <br><br><br>
        
        <form action="memberjoin" method="post" name="joinform">
            <table>
                <tr>
                    <td id="title">아이디</td>
                    <td>
                        <input type="text" name="mid" id="mid" onkeyup="idCheck()">
                         <span id="idch"></span>  
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">비밀번호</td>
                    <td>
                        <input type="password" name="mpassword" id="mpassword"  onkeyup="pwdCheck()"><span id="pwdch"></span><br>영대소문자, 숫자,특수문자 혼합 8~16자                     
                    </td>
                </tr>
                
                <tr>
                    <td id="title">비밀번호 확인</td>
                    <td>
                        <input type="password" id="mpasswordch" name="mpasswordch" onkeyup="pwdeqFn()">
                        <span id="pwdEq"></span>
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">이름</td>
                    <td>
                        <input type="text" name="mname" id="mname">
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">생년월일</td>
                    <td>
                        <input type="date" id="mbirth"name="mbirth">
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">주소</td>
                    <td>
                        <input type="text" name="mpostnum" id="sample4_postcode" placeholder="우편번호">
        <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
        <input type="text" name="maddressroad" id="sample4_roadAddress" placeholder="도로명주소">
        <input type="text" name="maddressjibun" id="sample4_jibunAddress" placeholder="지번주소"><br>
        <span id="guide" style="color:#999;display:none"></span>
        <input type="text" name="maddress" id="sample4_detailAddress" placeholder="상세주소">
        <input type="text" name="maddress1" id="sample4_extraAddress" placeholder="참고항목"><br>
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">휴대폰번호</td>
                    <td>
                        <input type="text" name="mphone" id="mphone" onkeyup="phoneCheck()">
                        <span id=phonech></span>
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">이메일</td>
                    <td>
                        <input type="email" name="memail" id="memail">
                    </td>
                </tr>
            </table>
            
            
        </form>
        <button onclick="join()">회원가입</button>
        <button onclick="location.href='MemberLogin.jsp'">로그인</button>
   
  
    
        
    </div>




</body>
</html>