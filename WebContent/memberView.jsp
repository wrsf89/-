<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.dto" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView.jsp</title>
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
td{
text-align:center;
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
<center><p class="pClass">홈쇼핑 회원 정보 수정</p></center>
<form action="memberUpdate" method="post" name="update">
<table border="1">
<% dto dto = (dto)request.getAttribute("memberView"); %>
 <tr>
  <td>회원번호</td>
  <td><input type="text" name="custno" value="<%=dto.getCustno() %>" readonly></td>
 </tr>
 <tr>
  <td>회원성명</td>
  <td><input type="text" name="custname" value="<%=dto.getCustname() %>"></td>
 </tr>
 <tr>
  <td>회원전화</td>
  <td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
 </tr>
 <tr>
  <td>회원주소</td>
  <td><input type="text" name="address" value="<%=dto.getAddress() %>"></td>
 </tr>
 <tr>
  <td>가입일자</td>
  <td><input type="text" name="joindate" value="<%=dto.getJoindate() %>"></td>
 </tr>
 <tr>
  <td>고객등급[A:VIP,B:일반,C:직원]</td>
  <td><input type="text" name="grade" value="<%=dto.getGrade() %>"></td>
 </tr>
 <tr>
  <td>도시코드</td>
  <td><input type="text" name="city" value="<%=dto.getCity()%>"></td>
 </tr>
 <tr>
  <td colspan="2">
  <input type="button" value="수정" onclick="updateChk()">
  <input type="button" value="조회" onclick="location.href='memberList'">
  </td>
 </tr>
</table>
</form>
</div>

<div class="footer">
 저작권 관련정보
</div>

</body>
</html>

<script>
function updateChk(){
	alert("회원정보수정이 완료 되었습니다.");
	document.update.submit();
}
</script>