<%@page import="myPkg.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp<br>


<form action="updateProc.do" method="post">

	<input type="hidden" name="num" value="${ mb.num }">
	아이디 : <input type="text" name="id" value="${ mb.id }"><br><br>

	비번 : <input type="text" name="passwd" value="${ mb.getPasswd() }"><br><br>

	이름 : <input type="text" name="name" value="${ mb['name'] }"><br><br>

	<input type="submit" value="수정하기">

</form> 