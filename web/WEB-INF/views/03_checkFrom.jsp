<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checking Form (1)</title>
</head>
<body>
<form name="check" action="/app/form" method="post">
email : <input name="email" type="text"><br>
age   : <input name="age" type="text"><br>
<input type="submit" value="Check through Action">
</form>
</body>
</html>