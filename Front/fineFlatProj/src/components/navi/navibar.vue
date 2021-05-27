<template>
    <div>
        <!-- <div>
            네비게이션입니다. =>
            <router-link to="/">HOME </router-link>
            <router-link to="/mapsearch">지도검색 </router-link>
            <router-link to="/keysearch">아파트명*지역검색 </router-link>
            <router-link to="/noticemain">공지사항 </router-link>
            <router-link to="/news">뉴스</router-link>
            <br />-->
            <!-- 위에서 고른 라우터 링크 값으로 라우터 뷰 단에서 출력된다. -->
        <!-- <router-view></router-view>
        </div>  -->
        <router-link class="navbar-brand" to="/">HOME </router-link>
        <!-- <a class="navbar-brand" href="index.html"><img src="./assets/img/logo.png" alt="" class="logo" /></a> -->
        <!-- <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
        > -->
            <!-- <span class="navbar-toggler-icon"></span>
        </button> -->
        <div class="collapse navbar-collapse my-2 my-lg-0" id="navbarSupportedContent">
            <div class="mainmenu">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <router-link class="navbar-brand" to="/">HOME </router-link>
                        <!-- <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a> -->
                    </li>
                    <li class="nav-item">
                        <router-link to="/mapsearch">지도검색 </router-link>
                        <!-- <a class="nav-link" href="whymisocial.html">Why MISCOIAL</a> -->
                    </li>
                    <li class="nav-item">
                        <router-link to="/keysearch">아파트명*지역검색 </router-link>
                        <!-- <a class="nav-link" href="feature.html">Features</a> -->
                    </li>

                    <!-- <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                            >Articles</a
                        >
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="articles.html">Blog</a>
                            <a class="dropdown-item" href="singleblog.html">Single Blog</a>
                        </div>
                    </li> -->
                    <li class="nav-item">
                                    <router-link to="/noticemain">공지사항 </router-link>

                        <!-- <a class="nav-link" href="pricing.html">Pricing</a> -->
                    </li>

                    <li class="getstart"><a class="active" href="getstarted.html">get started</a></li>
                </ul>
            </div>
        </div>
        <router-view></router-view>
    </div>
</template>

<script>
export default {};
</script>

<style></style>
