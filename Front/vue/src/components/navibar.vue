<template>
    <div>
        네비게이션입니다. =>
        <router-link to="/">HOME </router-link>
        <router-link to="/mapsearch">지도검색 </router-link>
        <router-link to="/keysearch">아파트명*지역검색 </router-link>
        <router-link to="/notice">공지사항 </router-link>
        <router-link to="/news">뉴스</router-link>
        <br />
        <router-view></router-view>
    </div>
</template>

<script>
export default {};
</script>

<style></style>
