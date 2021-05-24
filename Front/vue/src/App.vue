<template>
    <div id="app">
        <div id="nav">
            <!-- 탑헤더 컴포넌트를 임폴트 해와서 띄워준다 -->
            <top-header></top-header>
            <!-- 네비바 컴포넌트를 임폴트 해와서 띄워준다 -->
            <navi-bar></navi-bar>
        </div>
    </div>
</template>
<script>
import TopHeader from '@/components/navi/topheader.vue';
import NaviBar from '@/components/navi/navibar.vue';

export default {
    name: 'mainpage',
    components: {
        TopHeader,
        NaviBar,
    },
};
</script>

<style>
@import url('https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css');
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

#nav {
    padding: 30px;
}

#nav a {
    font-weight: bold;
    color: #2c3e50;
}

#nav a.router-link-exact-active {
    color: #42b983;
}

.table {
    width: 100%;
    margin: 20px auto;
    text-align: center;
}
th {
    background-color: #4d6bb3;
    color: white;
}
</style>
