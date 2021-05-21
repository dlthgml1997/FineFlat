<template>
    <div id="app">
        <div id="nav">
            <top-header></top-header>
            <navi-bar></navi-bar>
        </div>
    </div>
</template>
<script>
import NaviBar from '@/components/navibar.vue';
import TopHeader from '@/components/topheader.vue';

export default {
    name: 'mainpage',
    components: {
        // EmpList,
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
