<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checking Form List </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<h2>Form List</h2>

<form:form modelAttribute="memBean" name="dataForm" id="dataForm" action="/app/formListBean" method="POST">
<ul>
<c:forEach items="${memBean.list}" var="mb" varStatus="var">
	<li>${var.count}</li>
	<li>${mb.id}</li>
	<li><form:input type="text" path="list[${var.index}].name" /></li><br>
	<li><form:input type="text" path="list[${var.index}].email" /></li><br>
</c:forEach>
<!--<li>1</li>
<li></li>
<li><input type="text" name="list[0].name" /></li>
<li>2</li>
<li></li>
<li><input type="text" name="list[1].name" /></li>
<li>3</li>
<li></li>
<li><input type="text" name="list[2].name" /></li> -->

</ul>
<input type="submit" value="move"> 
</form:form>

</body>
<script type="text/javascript">
function renameForModelAttribute() {
   $("#dataForm").each( function (index) {
        $(this).find("input[name=name]").attr("name", "list[" + index + "].name");
   })
}

</script>
</html>