<template>
    <div>
        <b> 게시글 수정입니다. </b>
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

        <button @click="modifyHandler">수정완료</button>
        <button @click="gobackHandler">돌아가기</button>
        <button @click="deleteHandler">삭제</button>
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    data() {
        return {
            no: this.detail.no,
            sort: this.detail.sort,
            writer: this.detail.writer,
            title: this.detail.title,
            content: this.detail.content,
        };
    },
    props: {
        detail: {
            type: Array,
        },
    },
    methods: {
        gobackHandler() {
            this.$router.push('/noticemain');
        },
        modifyHandler() {
            // alert(this.title);

            axios
                .put(`/board/modify/${this.no}`, {
                    no: this.no,
                    writer: this.writer,
                    title: this.title,
                    content: this.content,
                    sort: this.sort,
                })
                .then(({ data }) => {
                    alert('수정되었습니다.');
                    this.$router.push('/noticemain');
                });
        },
        deleteHandler() {
            // alert(this.AT.no);
            axios.delete(`/board/delete/${this.AT.no}`).then((data) => {
                alert('삭제되었습니다.');
            });
            this.$router.push('/noticemain');
        },
    },
};
</script>

<style></style>
