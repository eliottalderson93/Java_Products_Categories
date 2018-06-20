<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.getName()}</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>${product.getName()}</h1>
<div>
<h4>Categories:</h4>
<c:forEach items="${categories_for_products}" var="cat">
				<p>- ${cat.name}</p>
</c:forEach>
</div>
<div>
<h5>Add new Product to This Category</h5>
<form:form action = "/product/${product.getId()}" method = "post" modelAttribute = "category">
	<form:select path = "category">
		<form:option value = "0" label = "Select One"/>
		<c:forEach items = "${form_categories}" var = "cat">
			<form:option value = "${cat.getId()}" label = "${cat.getName()}" />
		</c:forEach>
	</form:select>
</form:form>
</div>
<a href = "/new">Back</a>
</body>
</html>