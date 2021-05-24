<template>
    <div>
        <b> 게시글 작성입니다. </b>
        <br />
        <table>
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
                <td><input type="text" v-model="title" /></td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea
                        v-model="content"
                        id="content"
                        cols="30"
                        rows="10"
                    ></textarea>
                </td>
            </tr>
        </table>

        <button @click="postHandler">포스팅</button>
        <button @click="gobackHandler">돌아가기</button>
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
