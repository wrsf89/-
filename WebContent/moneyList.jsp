<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>    
<%@ page import = "dto.dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>moneyList.jsp</title>
<style>
.header{
 background-color: blue;
 height: 150px;
 color: white;
 text-align: center;
 font-size: 30px;
 line-height: 120px;
}
.nav{
 background-color: skyblue;
 height: 60px;
 line-height: 45px;
 font-size: 20px;
}
.aClass{
 color: white;
 text-decoration: none;
}
.pClass{
 font-size: 30px;
}
.footer{
 background-color: blue;
 height: 70px;
 font-size: 25px;
 line-height: 55px;
 margin-top: 200px;
 color: white;
 text-align: center;
}
table{
 margin-left: auto;
 margin-right: auto;
}
</style>
</head>
<body>
<div class="header">
 쇼핑몰 회원관리ver1.0
</div>

<div class="nav">
<a class="aClass" href="joinForm">회원등록</a>
<a class="aClass" href="memberList">회원목록조회/수정</a>
<a class="aClass" href="moneyList">회원매출조회</a>
<a class="aClass" href="index.jsp">홈으로</a>
</div>

<div class="section">
<center><p class="pClass">회원매출조회</p></center>

 <table border="1">
 <tr>
 <th>회원번호</th>
 <th>회원성명</th>
 <th>고객등급</th>
 <th>매출</th>
 </tr>
 <% ArrayList<dto> moneyList = (ArrayList<dto>)request.getAttribute("moneyList");
 for(int i =0; i < moneyList.size(); i++) { %>
 <tr>
  <td><%=moneyList.get(i).getCustno() %></td>
  <td><%=moneyList.get(i).getCustname() %></td>
  <td><%=moneyList.get(i).getGrade() %></td>
  <td><%=moneyList.get(i).getPrice() %></td>
 </tr>
 <% } %>
 </table>

</div>

<div class="footer">
 저작권 관련정보
</div>

</body>
</html>