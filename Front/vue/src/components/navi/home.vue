<template>
    <div>
        메인 페이지입니다
        <br />
        <br />
        ++++++++최신뉴스+++++++++++
        <br />
        <div v-if="loginCheck()">
            <router-link to="/user/login">로그인</router-link>
            <router-link to="/user/join">가입하기</router-link>
            <!-- 여기에 라우터 뷰를 넣으면?? -->
        </div>
        <div v-else>
            <b>{{ id }}님 환영합니다. <br />
                </b>
            <button @click="moveMypage()">마이페이지</button>
            <button @click="logoutHandler()">로그아웃</button>
        </div>
    </div>
</template>

<script>
export default {
    data: function () {
        return {
            id: '',
        };
    },
    created() {
        this.$store.dispatch();
    },
    methods: {
        loginCheck() {
            if (!sessionStorage.getItem('user')) {
                //로그인 유저가 없다면
                return true;
            } else {
                this.id = JSON.parse(sessionStorage.getItem('user')).id;
                return false;
            }
        },
        logoutHandler() {
            sessionStorage.removeItem('user');
            alert('안녕히가세요');
            location.reload();
        },
        moveMypage() {
            this.$router.push('/user/mypage');
        },
    },
};
</script>

<style></style>
