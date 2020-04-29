<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checking Form List Result</title>
</head>
<body>

 <br>
아이디 : ${row.getId()} <br>
등록일 : ${row.getJoined()} <br>
<ul>
<c:forEach items="${memberList}" var="row" varStatus="var">
	<li>${var.count}</li>
	<li>이름 : ${row.name}</li>
	<li>아이디 : ${row.getId()}</li>
	<li>등록일 : ${row.getJoined()}</li>
	<li>메일 : ${row.email}</li>
</c:forEach>
</ul>

</body>
</html>