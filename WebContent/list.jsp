<%@page import="myPkg.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>            
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>         
list.jsp<br>

<%
	ArrayList<MemberBean> lists = (ArrayList<MemberBean>) request.getAttribute("lists");
%>
<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비번</td>
		<td>이름</td> 
		<td>가입일</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>

	<c:forEach var="mb" items="${ lists }">
		<tr>
			<td>${ mb.num }</td>
			<td>${ mb["id"] }</td>
			<td>${ mb.getPasswd() }</td>
			<td>${ mb.name }</td> 
			<td>${ mb.register }</td>
			<td><a href="updateForm.do?num=${ mb.num }">수정</a></td>
			<td><a href="delete.do?num=${ mb.num }">삭제</a></td>
		</tr>
	</c:forEach>
	

</table>

<br><br>
<a href="insertForm.jsp">삽입</a>
