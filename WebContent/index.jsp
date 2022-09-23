<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
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
<center><p class="pClass">쇼핑몰 회원관리 프로그램</p></center>


</div>

<div class="footer">
 저작권 관련정보
</div>

</body>
</html>