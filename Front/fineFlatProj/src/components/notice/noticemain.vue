<template>
    <div class="con223">
        <div calss="bo">
            <br />
            <h1 style="font-family: 'KoHo', sans-serif; text-align: center">OFFICIAL NOTICE</h1>
            <b-button variant="success" @click="writing" style="margin: auto; display: block">글쓰기</b-button>
            <article-list :list-array="contents" />
        </div>
    </div>
</template>

<script>
import axios from '@/util/http-common';
import ArticleList from '@/components/notice/articlelist';

export default {
    components: {
        ArticleList,
    },
    data() {
        return {
            contents: [],
        };
    },
    created() {
        axios
            .get('/board/readlist')
            .then(({ data }) => {
                this.contents = data;
            })
            .catch(() => {
                alert('에러가 발생했습니다.');
            });
    },
    methods: {
        writing() {
            console.log(this);
            this.$router.push('/notice/articlewrite');
        },
    },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=KoHo:wght@700&family=Pattaya&display=swap');

.con223 {
    /* 시작을 위한 그리드 설정 */
    /* display: grid; */
    /* 가로 10칸으로 */
    /* grid-template-columns: repeat(20, 1fr); */
    /* 3칸으로 세로 나누기 */
    /* grid-template-rows: repeat(6, 1fr); */
    /* overflow: inherit; */
    /* max-height: 100%; */
    margin: 0% 0%;
    background: url('../../assets/img/FF/noticepg.png');
    background-size: 100%;
}
.bo2323 {
    /* grid-column: 4 / 14;
    grid-row: 2 / 6; */
    margin: 1em;
    width: 70%;
}
</style>
