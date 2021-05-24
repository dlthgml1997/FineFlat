<template>
    <div>
        네비게이션입니다. =>
        <router-link to="/">HOME </router-link>
        <router-link to="/mapsearch">지도검색 </router-link>
        <router-link to="/keysearch">아파트명*지역검색 </router-link>
        <router-link to="/noticemain">공지사항 </router-link>
        <router-link to="/news">뉴스</router-link>
        <br />
        <!-- 위에서 고른 라우터 링크 값으로 라우터 뷰 단에서 출력된다. -->
        <router-view></router-view>
    </div>
</template>

<script>
export default {};
</script>

<style></style>
