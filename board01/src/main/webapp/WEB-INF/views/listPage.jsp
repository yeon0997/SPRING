<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">게시판 목록보기</h1>
		</div>
	</div>
	<form action="regist" method="get">
		<table class="table table-hover">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${listAll}" var="boardVO">
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
		<!-- 페이지 처리를 위해 추가한 부분 시작 -->
		<ul class="pagination justify-content-center" style="margin: 20px 0">
			<c:if test="${pageMaker.prev}">
				<li class="page-item"><a class="page-link"
					href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1)
}">«</a>
				</li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li class="page-item"><c:out
						value="${pageMaker.cri.page == idx?'':''}" /> <a
					class="page-link" href="listPage${pageMaker.makeQuery(idx)}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li class="page-item"><a class="page-link"
					href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }"> »
				</a></li>
			</c:if>
		</ul>
		<br>
		<!-- 페이지 처리를 위해 추가한 부분 끝 -->
		<button type="submit">글쓰기</button>
	</form>
</body>
</html>