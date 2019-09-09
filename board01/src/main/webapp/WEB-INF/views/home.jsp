<!-- 첫 페이지(루트폴더) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>

<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">스프링프레임워크MVC 게시판</h1>
		</div>
	</div>
	<div class="container">
		<form action="listAll" method="get">
			<button type="submit" class="btn btn-warning">게시판</button>
		</form>
		<h1>Hello world!</h1>
		<p>The time on the server is ${serverTime}.</p>
	</div>
</body>
</html>