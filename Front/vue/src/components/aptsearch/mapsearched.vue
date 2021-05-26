<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>AptName</th>
          <th>Price</th>
          <th>Deal Year</th>
          <th>Build</th>
          <th>Floor</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="apt in paginatedData" :key="apt">
          <td>
            <button @click="updateClickCnt(apt.no, apt)">{{ apt.aptName }}</button>
          </td>
          <td>{{ apt.dealAmount }}</td>
          <td>{{ apt.dealYear }}</td>
          <td>{{ apt.buildYear }}</td>
          <td>{{ apt.floor }}</td>
        </tr>
      </tbody>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">이전</button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">다음</button>
    </div>
  </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
  name: 'apt-detail',
  data() {
    return {
      pageNum: 0,
      newlist: [],
    };
  },
  props: {
    listArray: {
      type: Array,
      required: true,
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10,
    },
  },
  methods: {
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
    shomedetail() {},
    updateClickCnt(no, apt) {
      axios.put(`/house/click/${no}`);

      this.$router.push({
        name: 'AptDetail',
        params: { AP: apt },
      });
    },
  },
  computed: {
    pageCount() {
      let listLeng = this.listArray.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.listArray.slice(start, end);
    },
  },
};
</script>

<style>
table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>
