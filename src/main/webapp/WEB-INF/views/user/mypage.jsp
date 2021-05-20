<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>HAPPYHOUSE-회원가입</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
var userid = "${memberDto.userid}";
var userpwd = "${memberDto.userpwd}";
var username = "${memberDto.username}";
var email = "${memberDto.email}".split("@")[0];
var site =  "${memberDto.email}".split("@")[1];
var tel1 = "${memberDto.tel}".slice(0,3);
var tel2 = "${memberDto.tel}".slice(3,7);
var tel3 = "${memberDto.tel}".slice(7,11);
var address = "${memberDto.address}";
$(document).ready(function() {
	$("#userid").val(userid);
	$("#userpwd").val(userpwd);
	$("#username").val(username);
	$("#tel1").val(tel1);
	$("#tel2").val(tel2);
	$("#tel3").val(tel3);
	$("#emailid").val(email);
	$("#emaildomain").val(site).prop("selected",true);
	$("#address_detail").val(address);

	$("#deleteBtn").click(function() {
		if($("#userpwd").val() == "") {
			alert("비밀번호를 입력하세요.");
			return;
		} else if($("#userpwd").val() != $("#pwdcheck").val()) {
			alert("비밀번호를 확인하세요.");
			return;
		} else {
			let id = $('#userid').val();
			$.ajax({
				url : '/user/delete/' + id,
				type : 'DELETE',
				contentType : 'application/json; charset=UTF-8',
				success : function(data) {
					location.href="/user/logout"					
				}
			});
		}
	});
	
	$("#registerBtn").click(function() {
		if($("#userpwd").val() == "") {
			alert("비밀번호를 입력하세요.");
			return;
		} else if($("#userpwd").val() != $("#pwdcheck").val()) {
			alert("비밀번호를 확인하세요.");
			return;
		} else {
			var jsondata = {
					"userid":$('#userid').val(),
					"userpwd":$('#userpwd').val(),
					"username":$('#username').val(),
					"tel":$('#tel1').val()+$('#tel2').val()+$('#tel3').val(),
					"email":$('#emailid').val()+"@"+$("#emaildomain option:selected").val(),
					"address":$('#address').val()+$('#address_detail').val()
			}
			
			$.ajax({
				url: '/user/modify',
				type: 'PUT',
				dataType: 'json',
				contentType: 'application/json; charset=UTF-8',
				data: JSON.stringify(jsondata),
				statusCode: {
					200: function(data) {
						alert("수정되었습니다.");
						location.href = "/";
					},
					500: function(data) {
						location.href = "/error/error";
					}
				}
			});
		}
	});
	 
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
});
</script>
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="container" align="center">
	<h3 class="mt-3">마이페이지</h3>
	<div class="col-lg-6" align="center">
		<form id="memberform" method="post" action="">
		<input type="hidden" name="act" id="act" value="">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="username" name="username" placeholder="" disabled>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" disabled>
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="pwdcheck" name="pwdcheck" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="emailid" name="email" placeholder="" size="25"> @
				<select class="form-control" id="emaildomain" name="emaildomain">
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="daum.net">daum.net</option>
					<option value="nate.com">nate.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label>
				<div id="tel" class="custom-control-inline">
				<select class="form-control" id="tel1" name="tel1">
					<option value="010">010</option>
					<option value="02">02</option>
					<option value="031">031</option>
					<option value="032">032</option>
					<option value="041">041</option>
					<option value="051">051</option>
					<option value="061">061</option>
				</select> _
				<input type="text" class="form-control" id="tel2" name="tel2" placeholder=""> _
				<input type="text" class="form-control" id="tel3" name="tel3" placeholder="">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="">주소</label><br>
				<div id="addressdiv" class="custom-control-inline">
					<input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" size="7" maxlength="5" readonly="readonly">
					<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
				</div>
				<input type="text" class="form-control" id="address" name="address" placeholder="">
				<input type="text" class="form-control" id="address_detail" name="address_detail" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn">수정하기</button>
				<button type="button" class="btn btn-light" id="deleteBtn">탈퇴하기</button>
			</div>
		</form>
	</div>
</div>

<div id="zipModal" class="modal fade" role="dialog">
<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>    
            <div class="modal-body text-center">
            	<form id = "zip_codeForm">
            		<div align="center">
            			<label>도로명 주소검색</label>
            		</div>
					<div class="input-group" align="left">
						<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 대왕판교로, 학하서로)">
						<span class="input-group-btn">
						<input type="submit" class="btn btn-warning" value="검색" id="searchBtn">
						</span>
					</div>
                </form>
                <div style="width:100%; height:200px; overflow:auto">
                	<table class = "table text-center">
                		<thead>
                		<tr>
                			<th style="width:150px;">우편번호</th>
                			<th style="width:600px;">주소</th>
                		</tr>
                		</thead>
                		<tbody id="zip_codeList"></tbody>
                	</table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>