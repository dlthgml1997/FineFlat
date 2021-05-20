<template>
    <div>
        <div class="text-center">
            <input
                type="text"
                id="keyword"
                placeholder="회원이름을 입력하세요"
            />
            <button class="btn btn-primary" @click="search">검색</button>
        </div>

        <div v-if="emps.length">
            <table class="table table-bordered table-condensed">
                <colgroup>
                    <col width="20%" />
                    <col width="20%" />
                    <col width="20%" />
                    <col width="20%" />
                    <col width="20%" />
                </colgroup>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>비밀번호</th>
                    <th>전화</th>
                    <th>주소</th>
                </tr>
                <tr v-for="(emp, idx) in emps" :key="idx + '_emps'">
                    <td>
                        <router-link :to="'detail?id=' + emp.userid">{{
                            emp.userid
                        }}</router-link>
                    </td>
                    <td>{{ emp.username }}</td>
                    <td>{{ emp.userpwd }}</td>
                    <td>{{ emp.tel }}</td>
                    <td>{{ emp.address }}</td>
                </tr>
            </table>
        </div>

        <div v-else class="text-center">등록된 회원이 없습니다.</div>
        <div class="text-right">
            <router-link :to="'/regist'"
                ><button class="btn btn-primary">등록</button></router-link
            >
        </div>
    </div>
</template>

<script>
//import axios from '@/util/http-common';
import { mapGetters } from 'vuex';

// export default {
//     data() {
//         return {
//             word: '',
//             //emps: [],
//         };
//     },
export default {
    data: function () {
        return {
            word: '',
            // emps: []
        };
    },
    computed: {
        ...mapGetters(['emps']),
    },
    created() {
        // axios
        //     .get('http://localhost:8097/hrmboot/api/employee/all')
        //     .then(({ data }) => {
        //         this.emps = data;
        //     });
        this.$store.dispatch('getEmps');
    },
    methods: {
        search() {
            this.word = document.querySelector('#keyword').value;
        },
    },
};
</script>

<style></style>
