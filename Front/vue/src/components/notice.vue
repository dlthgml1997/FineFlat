<template>
    <div>
        공지사항페이지입니다.
        <br>
    <table>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>종류</th>
        <th>제목</th>
        <th>내용</th>
        <th>날짜</th>
      </tr>
      <tr
      v-for="article in contents"
      :key="article.no"
      >
      <th>
        <router-link to="/boardDetail" 
        :no="article.no"
        :writer="article.writer"
        :sort="article.sort"
        :title="article.title"
        :content="article.content"
        :reg="article.reg"
        >{{article.no}}</router-link>
        </th> 
      <th>{{article.writer}}</th> 
      <th>{{article.sort}}</th> 
      <th>{{article.title}}</th> 
      <th>{{article.content}}</th> 
      <th>{{article.reg}}</th> 
      </tr>
    </table>
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    data() {
        return {
            contents: [],
        };
    },
    created() {
        // axios
        //     .get('/board')
        //     .then(({ data }) => {
        //         this.items = data;
        //     })
        //     .catch(() => {
        //         alert('에러가 발생했습니다.');
        //     });
    },
};
</script>

<style></style>
