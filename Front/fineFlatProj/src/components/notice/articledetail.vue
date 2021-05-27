<template>
    <div class="con223">
        <h1 style="font-family: 'KoHo'; sans-serif; text-align: center">ARTICLE</h1>
        <br />
        <table style="font-family: 'Pattaya', sans-serif">
            <tr>
                <td>no.</td>
                <td>{{ AT.no }}</td>
            </tr>
            <tr>
                <td>SORT.</td>
                <td>{{ AT.sort }}</td>
            </tr>
            <tr>
                <td>WRITER</td>
                <td>{{ AT.writer }}</td>
            </tr>
            <tr>
                <td>TITLE.</td>
                <td>{{ AT.title }}</td>
            </tr>
            <tr>
                <td>CONTENTS.</td>
                <td>{{ AT.content }}</td>
            </tr>
            <tr>
                <td>DATE.</td>
                <td>{{ AT.regtime }}</td>
            </tr>
        </table>

        <b-button style="font-family: 'KoHo'; margin: auto; display: block" @click="gobackHandler">돌아가기</b-button>
        <b-button style="font-family: 'KoHo'; margin: auto; display: block" variant="success" @click="modifyHandler">수정</b-button>
        <b-button style="font-family: 'KoHo'; margin: auto; display: block" variant="danger" @click="deleteHandler">삭제</b-button>
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
            // this.$router.push('/notice');
            this.$router.go(-1);
        },
        modifyHandler() {
            // alert(this.AT.no);
            this.$router.push({
                name: 'articlemodi',
                params: { detail: this.AT },
            });
        },
        deleteHandler() {
            alert(this.AT.no);
            axios.delete(`/board/delete/${this.AT.no}`).then((data) => {
                alert('삭제되었습니다.');
                this.$router.push('/noticemain');
            });
        },
    },
};
</script>

<style></style>
