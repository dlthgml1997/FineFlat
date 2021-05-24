<template>
    <div>
        <b> 게시글 수정입니다. </b>
        <br />
        {{ $route.params.AT }}
        <br />
        넘버 {{ AT.no }} <br />
        종류 {{ AT.sort }} <br />
        글쓴 {{ AT.writer }} <br />
        제목 {{ AT.title }} <br />
        내용 {{ AT.content }} <br />
        날짜 {{ AT.regtime }} <br />

        <button @click="modifyHandler">수정완료</button>
        <button @click="gobackHandler">돌아가기</button>
        <button @click="deleteHandler">삭제</button>
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    name: 'detail-apt',
    props: {
        AT: {
            type: Array,
        },
    },
    methods: {
        gobackHandler() {
            this.$rounter.go(-1);
        },
        modifyHandler() {
            this.$router.push('/user/mypage');
        },
    },
};
</script>

<style></style>
