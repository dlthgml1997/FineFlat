<template>
    <div>
        메인 페이지입니다
        <br />
        로그인 버튼과 환영합니다 <br />
        가입버튼 <br />
        최신뉴스
        <div v-show="true">
            <router-link to="/user/login">로그인</router-link>
            <router-link to="/user/join">가입하기</router-link>
            
        </div>
    </div>
</template>

<script>
export default {
    data: function () {
        return {};
    },
    created() {
        this.$store.dispatch();
    },
};
</script>

<style></style>
