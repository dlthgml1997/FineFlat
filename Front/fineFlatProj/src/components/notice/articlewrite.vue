<template>
    <div class="con223" style="font-family: 'KoHo'">
        <h1 style="font-family: 'KoHo'; sans-serif; text-align: center">WRITE YOUR ARTICLE</h1>
        <br />
        <table style="font-family: 'Pattaya', sans-serif">
            <tr>
                <th>종류</th>
                <td>
                    <select v-model="sort">
                        <option value="공지사항">공지사항</option>
                        <option value="이벤트">이벤트</option>
                        <option value="일반글">일반글</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>글쓴이</th>
                <td>
                    <input type="text" v-model="writer" readonly />
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" v-model="title" style="
    width: 80%;
"/></td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea v-model="content" id="content" cols="100" rows="20"></textarea>
                </td>
            </tr>
        </table>

        <b-button style="font-family: 'KoHo';margin: auto; display: block" variant="success" @click="postHandler">Posting</b-button>
        <b-button style="font-family: 'KoHo';margin: auto; display: block" @click="gobackHandler">Back</b-button>
    </div>
</template>

<script>
import axios from '@/util/http-common';
// import router from '@/router/';
export default {
    name: 'detail-apt',
    component: {},
    props: {
        AT: {
            type: Array,
        },
    },
    data() {
        return {
            sort: '',
            writer: JSON.parse(sessionStorage.getItem('user')).id,
            title: '',
            content: '',
        };
    },
    methods: {
        gobackHandler() {
            this.$router.push('/noticemain');
        },
        postHandler() {
            axios
                .post('/board/create', {
                    sort: this.sort,
                    writer: this.writer,
                    title: this.title,
                    content: this.content,
                })
                .then(({ data }) => {
                    alert('포스팅되었습니다.');
                    this.gobackHandler();
                });
        },
    },
};
</script>

<style></style>
