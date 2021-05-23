<template>
    <div class="container">
        <div>아파트 지역검색 페이지</div>
        <section id="index_section">
            <div class="card col-sm-12 mt-1" style="min-height: 850px">
                <div class="card-body">
                    아파트 이름으로 검색:
                    <input type="text" v-model="searchKey" />
                    {{ searchKey }}
                    <button @click="searchBtn">검색</button>
                    <!-- <table>
                        <tr>
                            <td></td>
                            <td>
                                <select id="searchKey">
                                    <option
                                        value="동이나 아파트 이름으로 검색합니다."
                                    ></option>
                                    <option value="dongSearch">동 검색</option>
                                    <option value="aptSearch">
                                        아파트 이름 검색
                                    </option>
                                </select>
                            </td>
                        </tr>
                    </table> -->

                    <paging-list :list-array="aptlist" />
                    <!-- <table>
                        <thead>
                            <tr>
                                <th>동</th>
                                <th>아파트이름</th>
                                <th>건축 년도</th>
                                <th>지번</th>
                                <th>거래금액</th>
                                <th>거래연도</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table> -->
                </div>
            </div>
        </section>
    </div>
</template>

<script>
import axios from '@/util/http-common';

import PagingList from '@/components/pageingName';
export default {
    components: {
        PagingList,
    },
    data() {
        return {
            searchKey: '',
            aptlist: [],
        };
    },

    methods: {
        searchBtn() {
            axios
                .get('/house/searchName/' + this.searchKey)
                .then(({ data }) => {
                    console.log(data);
                    this.aptlist = data;
                });
        },
    },
};
</script>

<style></style>
