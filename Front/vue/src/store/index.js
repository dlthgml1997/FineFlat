import Vue from 'vue';
import Vuex from 'vuex';
//엑시오스를 추가해주고
import axios from '@/util/http-common.js';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        emps: [],
        emp: {},
    },
    // 요청값에 따라 넘겨주기
    getters: {
        emps(state) {
            return state.emps;
        },
        emp(state) {
            return state.emp;
        },
    },
    mutations: {
        //33번의 데이터가
        setEmps(state, payload) {
            state.emps = payload;
            //
        },
        setEmp(state, payload) {
            state.emp = payload;
        },
    },
    actions: {
        getEmps({ commit }) {
            axios.get('/userList').then(({ data }) => {
                commit('setEmps', data);
                //커밋으로 뮤테이션을 부른다 tㄴㅇㄹ마ㅣㅜ니아ㅜ리ㅏㅁㄴ위ㅏ루
            });
        },
        // getEmps(context) {
        //     axios.get('/all').then(({ data }) => {
        //         context.commit('setEmps', data);
        //         //커밋으로 뮤테이션을 부른다
        //     });
        // },
        getEmp(context, payload) {
            axios.get('' + payload).then(({ data }) => {
                context.commit('setEmp', data);
            });
        },
    },
    modules: {},
});
