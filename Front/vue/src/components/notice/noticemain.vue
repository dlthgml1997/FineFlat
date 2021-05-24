<template>
    <div>
        공지사항페이지입니다.
        <br />
        <button @click="writing">글쓰기</button>
        <article-list :list-array="contents" />
        <!-- <table>
            <tr>
                <th>번호</th>
                <th>작성자</th>
                <th>종류</th>
                <th>제목</th>
                <th>내용</th>
                <th>날짜</th>
            </tr>

            <tr v-for="article in contents" :key="article.no">
                <th>
                    <router-link
                        to="/boardDetail"
                        :no="article.no"
                        :writer="article.writer"
                        :sort="article.sort"
                        :title="article.title"
                        :content="article.content"
                        :reg="article.reg"
                        >{{ article.no }}</router-link
                    >
                </th>
                <th>{{ article.writer }}</th>
                <th>{{ article.sort }}</th>
                <th>{{ article.title }}</th>
                <th>{{ article.content }}</th>
                <th>{{ article.reg }}</th>
            </tr>
        </table> -->
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

<style></style>
