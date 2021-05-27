<template>
    <div>
        <table style="font-family: 'KoHo'">
            <thead style="background-color: rgb(237, 134, 108); font-color: reg(5, 13, 94); opacity: 1;">
                <tr>
                    <th>Apt</th>
                    <th>Price</th>
                    <th>Deal Year</th>
                    <!-- <th>Build</th>
                    <th>Floor</th> -->
                </tr>
            </thead>
            <tbody>
                <tr v-for="apt in paginatedData" :key="apt">
                    <td>
                        <router-link
                            :to="{
                                name: 'AptDetail',
                                params: { AP: apt },
                            }"
                            >{{ apt.aptName }}
                        </router-link>
                        <!-- 여기엔 라우터 뷰 넣으면? -->
                    </td>
                    <td>{{ apt.dealAmount }}</td>
                    <td>{{ apt.dealYear }}</td>
                    <!-- <td>{{ apt.buildYear }}</td>
                    <td>{{ apt.floor }}</td> -->
                </tr>
            </tbody>
        </table>
        <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn" style="width: 1.5rem">&lt;</button>
            <span class="page-count" style="font-size: 10px">{{ pageNum + 1 }} / {{ pageCount }} page</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn" style="width: 1.5rem">&gt;</button>
        </div>
    </div>
</template>

<script>
import AptDetail from '@/components/aptsearch/aptdetail';
//이거 필요해?
export default {
    name: 'apt-detail',
    components: {
        AptDetail,
    },
    //이거 필요해?
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
            default: 7,
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
tr:nth-child(2n) {
    background-color: rgb(237, 134, 108);
    opacity: 0.7;
}
tr:nth-child(2n + 1) {
    background-color: #e3f2fd;
    opacity: 0.7;
}

.btn-cover {
    margin-top: 1.5rem;
    text-align: center;
}
.btn-cover .page-btn {
    width: 1rem;
    height: 2rem;
    letter-spacing: 0.5px;
}
.btn-cover .page-count {
    padding: 0 1rem;
}
</style>
