<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Products and Categories</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div>
	<h2>New Product</h2>
	<form:form action = "/new/products" method = "post" modelAttribute = "product">
		<p>
			<form:label path = "name">Name: </form:label>
			<form:errors path = "name"/>
			<form:input path = "name"/>
		</p>
		<p>
			<form:label path = "desc">Description: </form:label>
			<form:errors path = "desc"/>
			<form:input path = "desc"/>
		</p>
		<p>
			<form:label path = "price">Price: </form:label>
			<form:errors path = "price"/>
			<form:input path = "price"/>
		</p>
		<button type = "submit">Create</button>
	</form:form>
</div>
<div>
	<h2>New Category</h2>
	<form:form action = "/new/category" method = "post" modelAttribute = "category">
		<p>
			<form:label path = "name">Name: </form:label>
			<form:errors path = "name"/>
			<form:input path = "name"/>
		</p>
		<button type = "submit">Create</button>
	</form:form>
</div>

</body>
</html>