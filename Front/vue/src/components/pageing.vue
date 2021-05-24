<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>citycode</th>
                    <th>dong</th>
                    <th>AptName</th>
                    <th>post number</th>
                    <th>위도</th>
                    <th>경도</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="apt in paginatedData" :key="apt">
                    <td>{{ apt.code }}</td>
                    <td>{{ apt.dong }}</td>
                    <td>
                        <router-link
                            :to="{
                                name: 'Aptdetail',
                                params: { AP: apt },
                            }"
                            >{{ apt.aptName }}
                        </router-link>
                    </td>
                    <td>{{ apt.jibun }}</td>
                    <td>{{ apt.lat }}</td>
                    <td>{{ apt.lng }}</td>
                </tr>
            </tbody>
            \
        </table>
        <div class="btn-cover">
            <button
                :disabled="pageNum === 0"
                @click="prevPage"
                class="page-btn"
            >
                이전
            </button>
            <span class="page-count"
                >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
            >
            <button
                :disabled="pageNum >= pageCount - 1"
                @click="nextPage"
                class="page-btn"
            >
                다음
            </button>
        </div>
    </div>
</template>

<script>
import DetailApt from '@/components/aptdetail';

export default {
    name: 'paging-list',
    components: {
        DetailApt,
    },
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
