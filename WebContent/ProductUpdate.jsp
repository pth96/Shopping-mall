<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
   function ProductUpdateProcess(){
	   updateform.submit();
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
</head>
<body>
<div id="wrap">
        <br><br>
        <b><font size="6" color="gray">상품수정</font></b>
        <br><br><br>
        <form action="productupdateprocess" method="post" name="updateform" enctype="multipart/form-data">
            <table>
                <tr>
                    <td id="title">상품코드</td>
                    <td>
                      <input type="text" name="pid" id="pid" value="${productupdate.pid}" readonly> 
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">상품이름</td>
                    <td>
                       <input type="text" name="pname" id="pname" value="${productupdate.pname}">                   
                    </td>
                </tr>
                
                <tr>
                    <td id="title">상품가격</td>
                    <td>
                       <input type="text" id="pprice"name="pprice" value="${productupdate.pprice}">
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품내용</td>
                    <td>
                         <textarea rows="10" cols="10" name="pcontents" id="pcontents">${productupdate.pcontents}</textarea>
        
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품성별</td>
                    <td>
                         <select name="pgender" id="pgender">
                       <option value="${productupdate.pgender}" selected="selected">${productupdate.pgender}</option>                                      
                       <option value = "MAN">남성(Man)</option>
                       <option value = "WOMAN">여성(Woman)</option>
                       <option value = "KIDS">아동(kids)</option>
                       </select>
                      
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품수량</td>
                    <td>
                        <input type="text" name="pquantity" id="pquantity" value="${productupdate.pquantity}">
                    </td>
                </tr>   
                <tr>
                    <td id="title">상품사진</td>
                    <td>
                        <img src="Uploadfile/${productupdate.pfilename}" width="200" height="200">
                    </td>
                </tr>   
                <tr>
                    <td id="title">사진등록</td>
                    <td>
                       <input type="file" name="pfile" id="pfile">
                    </td>
                </tr>
                 <tr>
                    <td id="title">조회수</td>
                    <td>
                        ${productupdate.phits}
                      
                    </td>
                </tr>  
                 <tr>
                    <td id="title">등록일</td>
                    <td>
                        ${productupdate.pdate}
                      
                    </td>
                </tr>            
            </table>
                         
         </form>
         <button onclick="ProductUpdateProcess()">정보수정</button>
         </div>

</body>
</html>