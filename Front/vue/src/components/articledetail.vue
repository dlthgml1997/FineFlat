<template>
    <div>
        게시글 디테일입니다.
        <br />
        {{ $route.params.AT }}
        <br />
        넘버 {{ AT.no }} <br />
        종류 {{ AT.sort }} <br />
        글쓴 {{ AT.writer }} <br />
        제목 {{ AT.title }} <br />
        내용 {{ AT.content }} <br />
        날짜 {{ AT.regtime }} <br />

        <button @click="gobackHandler">돌아가기</button>
        <button @click="modifyHandler">수정</button>
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
            this.$router.push('/articlemodi');
        },
        deleteHandler() {
            axios.delete('/board/delete', { no: this.AT.no }).then((data) => {
                alert('');
            });
            this.$rounter.go(-1);
        },
    },
};
</script>

<style></style>
