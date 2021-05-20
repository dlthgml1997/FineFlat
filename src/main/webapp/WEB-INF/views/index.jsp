<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  
  <!-- Favicons -->
  <link href="${root}/img/favicon.png" rel="icon">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=https://fonts.googleapis.com/css?family=Inconsolata:400,500,600,700|Raleway:400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
</head>
<body>
<div align="center">
<%@ include file="/WEB-INF/views/include/header.jsp" %>

   <!-- ======= Works Section ======= -->
    <section class="section site-portfolio">
      <div class="container mt-4">
        <div id="portfolio-grid" class="row no-gutter" data-aos="fade-up" data-aos-delay="200">
          <div class="item web col-sm-6 col-md-6 col-lg-6 mb-4" style="text-align: center;">
            <a href="${root }/board" class="item-wrap fancybox">
              <div class="work-info">
                <h3 class="text-dark">최신 뉴스</h3>
              </div>
              <img class="img-fluid" src="img/notice.png">
            </a>
          </div>
          <div class="item photography col-sm-6 col-md-6 col-lg-6 mb-4" style="text-align: center;">
            <a href="${root }/house/aptSearch" class="item-wrap fancybox">
              <div class="work-info">
                <h3 class="text-dark">아파트별 실거래 검색</h3>
              </div>
              <img class="img-fluid" src="img/search.png">
            </a>
          </div>
          <div class="item branding col-sm-6 col-md-6 col-lg-6 mb-4" style="text-align: center;">
            <a href="${root }/house/mapSearch" class="item-wrap fancybox">
              <div class="work-info">
                <h3 class="text-dark">지도</h3>
              </div>
              <img class="img-fluid" src="img/map.png">
            </a>
          </div>
        </div>
      </div>
    </section><!-- End  Works Section -->
    <%@ include file="/WEB-INF/views/include/footer.jsp" %>
</div>
</body>
</html>