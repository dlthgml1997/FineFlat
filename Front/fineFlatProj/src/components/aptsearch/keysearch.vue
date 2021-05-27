<template>
    <div class="con1232">
        <div class="areaky" style="">
            <div class="cb">
                아파트 이름을 적어주세요 :
                <input type="text" v-model="searchKey" />
                <button @click="searchBtn">검색</button>
                <key-searched :list-array="aptlist" />
            </div>
        </div>
    </div>
</template>

<script>
import axios from '@/util/http-common';

import KeySearched from '@/components/aptsearch/keysearched';
export default {
    components: {
        KeySearched,
    },
    data() {
        return {
            searchKey: '',
            aptlist: [],
        };
    },

    methods: {
        searchBtn() {
            axios.get('/house/searchName/' + this.searchKey).then(({ data }) => {
                console.log(data);
                this.aptlist = data;
            });
        },
    },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=KoHo:wght@700&family=Pattaya&display=swap');
.con1232 {
    display: grid;
    /* 가로 20칸으로 */
    grid-template-columns: repeat(20, 1fr);
    /* 3칸으로 세로 나누기 */
    grid-template-rows: repeat(12, 1fr);
    background: url('../../assets/img/FF/p32.png');
    background-size: 100%;
}
.cb {
    text-align: center;
    font-size: 30px;
    font-family: 'Pattaya', sans-serif;
    color: rgb(231, 240, 236);
}
.areaky {
    grid-area: 3 / 6 / 10 / 16;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
}
#index_section {
    grid-area: 1 / 1 / 2 / 24;
}
</style>
