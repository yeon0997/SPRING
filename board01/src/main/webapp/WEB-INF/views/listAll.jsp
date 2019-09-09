<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Board list</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">게시판-글목록전체보기</h1>
		</div>
	</div>
	<div class="container">
		<table class="table table-hover">
			<thead class="thead-light">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="boardVO">
				<tr>
					<td>${boardVO.bno}</td>
					<td><a href='/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
					<td>${boardVO.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardVO.regdate}" /></td>
					<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
				</tr>
			</c:forEach>
		</table>
		<form action="regist" method="get">
			<button type="submit">글쓰기</button>
		</form>
	</div>
</body>
</html>