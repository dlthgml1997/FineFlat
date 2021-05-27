<template>
    <div class="con223">
        <h1 style="font-family: 'KoHo'; sans-serif; text-align: center">MODIFY ARTICLE</h1>

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

        <b-button style="font-family: 'KoHo';margin: auto; display: block" variant="success" @click="modifyHandler">수정완료</b-button>
        <b-button style="font-family: 'KoHo';margin: auto; display: block" variant="" @click="gobackHandler">돌아가기</b-button>
        <b-button style="font-family: 'KoHo';margin: auto; display: block" variant="danger" @click="deleteHandler">삭제</b-button>
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
