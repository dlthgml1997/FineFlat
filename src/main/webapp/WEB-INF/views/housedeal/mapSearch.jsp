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
<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCH8zOZm67DFhSiaZinJv53pImAUcw3jqk&callback=initMap"></script>
<script type="text/javascript">
let colorArr = ['table-primary','table-success','table-danger'];
$(document).ready(function(){
	// 	시  요청 후 받아오기
	$.ajax({
		url:'/house/sido',
		type: 'GET',
		success: function(data) {
			$.each(data, function(index, vo) {
				$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
			});//each
		}
	})
	
	// 구 요청 후 받아오기
	$("#sido").change(function() {
		if(this.value !== ""){
            var optVal = $(this).find(":selected").val();
        }
		$.ajax({
			url:'/house/gugun/'+optVal,
			type: 'GET',
			success: function(data) {
				$("#gugun").empty();
				$.each(data, function(index, vo) {
					$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
				});//each
			}
		})
	});
		//test
	// 동 요청 후 받아오기	
	$("#gugun").change(function() {
	let firstcode="";
		if(this.value !== ""){
            var optVal = $(this).find(":selected").val();
            firstcode+=optVal;
        }
		$.ajax({
			url:'/house/dong/'+optVal,
			type: 'GET',
			success: function(data) {
				$("#dong").empty();
				$.each(data, function(index, vo) {
					$("#dong").append("<option value='"+vo.code+"'>"+vo.dong+"</option>");
				});//each
			}
		})
	});
	
	
	$("#dong").change(function() {
		if(this.value !== ""){
            var optVal = $(this).find(":selected").val();
            var totalcode= $("#sido").find(":selected").val() + $("#gugun option:selected").val() + optVal;
        }
		$.ajax({
			url:'/house/dongApt/'+totalcode,
			type: 'GET',
			success: function(data, status){
					$("#searchResult").empty();
					$("tbody").empty();
					$.each(data, function(index, vo) {
						let str = "<tr class="+colorArr[index%3]+">"
						+ "<td>" + vo.no + "</td>"
						+ "<td>" + vo.dong + "</td>"
						+ "<td>" + vo.aptName + "</td>"
						+ "<td>" + vo.jibun + "</td>"
						+ "<td>" + vo.code
						+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
						$("tbody").append(str);
						$("#searchResult").append(vo.dong+" "+vo.aptName+" "+vo.jibun+"<br>");
					});//each
					geocode(data);
				}//function
			})
		})
	});//ready
	
	function geocode(jsonData) {
		let idx = 0;
		$.each(jsonData, function(index, vo) {
			let tmpLat;
			let tmpLng;
			$.get("https://maps.googleapis.com/maps/api/geocode/json"
					,{	key:'AIzaSyCQ7zNRn0oeJItnBmqgyufaBlt1lh509Xk'
						, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
					}
					, function(data, status) {
						//alert(data.results[0].geometry.location.lat);
						tmpLat = data.results[0].geometry.location.lat;
						tmpLng = data.results[0].geometry.location.lng;
						$("#lat_"+index).text(tmpLat);
						$("#lng_"+index).text(tmpLng);
					}
					, "json"
			);//get
		});//each
	}
	</script>
</head>
<body>
<div class="container">
		<section id="index_section">
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">
				
				시도 : <select id="sido">
					<option value="0">선택</option>
				</select>
				구군 : <select id="gugun">
					<option value="0">선택</option>
				</select>
				읍면동 : <select id="dong">
					<option value="0">선택</option>
				</select>
				
				<table class="table mt-2">
					<thead>
						<tr>
							<th>번호</th>
							<th>법정동</th>
							<th>아파트이름</th>
							<th>지번</th>
							<th>지역코드</th>
							<th>위도</th>
							<th>경도</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>

				<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
				<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
				<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQ7zNRn0oeJItnBmqgyufaBlt1lh509Xk&callback=initMap"></script>
				<script>
					var multi = {lat: 37.5665734, lng: 126.978179};
					var map;
					function initMap() {
						map = new google.maps.Map(document.getElementById('map'), {
							center: multi, zoom: 12
						});
						var marker = new google.maps.Marker({position: multi, map: map});
					}
					function addMarker(tmpLat, tmpLng, aptName) {
						var marker = new google.maps.Marker({
							position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
							label: aptName,
							title: aptName
						});
						marker.addListener('click', function() {
							map.setZoom(17);
							map.setCenter(marker.getPosition());
							callHouseDealInfo();
						});
						marker.setMap(map);
					}
					function callHouseDealInfo() {
						alert("you can call HouseDealInfo");
					}
				</script>
				</div>
			</div>
		</section>
	</div>
</body>
</html>