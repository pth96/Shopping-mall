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
</head>
<body>
 <div id="wrap">
        <br><br>
        <b><font size="6" color="gray">상품등록</font></b>
        <br><br><br>
        
        <form action="prregist" method="post" name="registform" enctype="multipart/form-data">
            <table>
                <tr>
                    <td id="title">상품코드</td>
                    <td>
                        <input type="text" name="pid" id="pid">
            
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">상품이름</td>
                    <td>
                        <input type="text" name="pname" id="pname">                     
                    </td>
                </tr>
                              
                <tr>
                    <td id="title">상품가격</td>
                    <td>
                        <input type="text" name="pprice" id="pprice">
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품설명</td>
                    <td>
                        <textarea rows="10" cols="10" name="pcontents" id="pcontents"></textarea>
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품성별</td>
                    <td>
                       <select name="pgender" id="pgender">
                       <option value = "MAN">남성(Man)</option>
                       <option value = "WOMAN">여성(Woman)</option>
                       <option value = "KIDS">아동(kids)</option>
                       
                       </select>
        
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">재고수량</td>
                    <td>
                        <input type="text" name="pquantity" id="pquantity">
                    
                    </td>
                </tr>
                    
                <tr>
                    <td id="title">상품이미지</td>
                    <td>
                       <input type="file" name="pfile" id="pfile">
                    </td>
                </tr>
            </table>
            <button>등록</button>
        </form>
     
    </div>

</body>
</html>