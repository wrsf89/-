<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
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
<center><p class="pClass">홈쇼핑 회원 등록</p></center>
<form action="memberJoin" method="post" name="join">
<table border="1">
 <tr>
  <td>회원번호(자동생성)</td>
  <td><input type="text" name="custno" value="<%=session.getAttribute("nextCno")%>"></td>
 </tr>
 <tr>
  <td>회원성명</td>
  <td><input type="text" name="custname"></td>
 </tr>
 <tr>
  <td>회원전화</td>
  <td><input type="text" name="phone"></td>
 </tr>
 <tr>
  <td>회원주소</td>
  <td><input type="text" name="address"></td>
 </tr>
 <tr>
  <td>가입일자</td>
  <td><input type="text" name="joindate"></td>
 </tr>
 <tr>
  <td>고객등급[A:VIP,B:일반,C:직원]</td>
  <td><input type="text" name="grade"></td>
 </tr>
 <tr>
  <td>도시코드</td>
  <td><input type="text" name="city"></td>
 </tr>
 <tr>
  <td colspan="2">
  <input type="button" value="등록" onclick="joinChk()">
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
function joinChk(){
	if(document.join.custname.value==""){
		alert("이름을 입력해주세요");
		document.join.custname.focus();
		return false;
	}
	if(document.join.phone.value==""){
		alert("전화번호를 입력해주세요");
		document.join.phone.focus();
		return false;
	}
	if(document.join.address.value==""){
		alert("회원주소를 입력해주세요");
		document.join.address.focus();
		return false;
	}
	
	if(document.join.joindate.value==""){
		alert("가입일자를 입력해주세요");
		document.join.joindate.focus();
		return false;
	}
	if(document.join.grade.value==""){
		alert("고객등급을 입력해주세요");
		document.join.grade.focus();
		return false;
	}
	if(document.join.city.value==""){
		alert("도시코드를 입력해주세요");
		document.join.city.focus();
		return false;
	}
	alert("회원등록이 완료 되었습니다.");
	document.join.submit();
}
</script>