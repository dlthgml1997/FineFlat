<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>HAPPY HOUSE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//  동 검색이냐 아파트명 검색이냐

		$("#searchBtn").click(function () {
				alert("dongsearchready");
				$.ajax({
					url:'/house/searchDong/'+$("#searchWord").val(),
					type: 'GET',
					contentType:'application/json;charset=utf-8',
					success: function(data, status){
						alert("sc");
						
						$.each(data, function(index, vo) {
							let str = "<tr>"
							+ "<td>" + vo.no + "</td>"
							+ "<td>" + vo.dong + "</td>"
							+ "<td>" + vo.aptName + "</td>"
							+ "<td>" + vo.buildYear + "</td>"
							+ "<td>" + vo.jibun + "</td>"
							+ "</tr>";
							$("#tb").append(str);
						});//each
					}//function
				});
			});
});
</script>
</head>
<body>
	<div class="container">
		<section id="index_section">
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">

					<table>
						<tr>
							<td>검색: </td>
							<td>
								<select id="searchKey">
									<option value="">
									<option value="dongSearch">동</option>
									<option value="aptSearch">아파트 이름</option>
								</select>								
							</td>
							<td><input type="text" id="searchWord" ></td>
							<td><button id="searchBtn"> 검색</button></td>
						</tr>
					</table>
		
				<table class="table mt-2">
					<thead>
						<tr>
							<th>번호</th>
							<th>법정동</th>
							<th>아파트이름</th>
							<th>건축 년도</th>
							<th>지번</th>
						</tr>
					</thead>
					
					<tbody id="tb">
					</tbody>
				</table>
				</div>
				
			</div>
		</section>
	</div>
</body>
</html>