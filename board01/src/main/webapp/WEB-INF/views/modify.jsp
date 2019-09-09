<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">글수정</h1>
		</div>
	</div>
	<div class="container">
		<form action="modify" method="post" class="form-horizontal">
			<div class="form-group row">
				<label class="col-sm-2 control-label">글번호</label>
				<div class="col-sm-8">
					<input type="text" name="bno" value="${boardVO.bno}"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">제목</label>
				<div class="col-sm-8">
					<input type="text" name="title" value="${boardVO.title}">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">작성자</label>
				<div class="col-sm-8">
					<input type="text" name="writer" size="15"
						value="${boardVO.writer}" readonly="readonly">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">내용</label>
				<div class="col-sm-8">
					<textarea name=content rows="15" cols="70">${boardVO.content}</textarea>
					<br>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit">완료</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>