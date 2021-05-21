import Vue from 'vue';
import Vuex from 'vuex';
//엑시오스를 추가해주고
import axios from '@/util/http-common.js';
// import getters from './getters';
// import actions from './actions';
// import mutations from './mutations';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        //=====user
        id: '',
        errorState: '',
        isAuth: false,
        member: {
            id: '',
            pw: '',
            email: '',
            tel: '',
            name: '',
            address: '',
        },
        //=====
        emps: [],
        emp: {},
    },
    // 요청값에 따라 넘겨주기
    getters: {
        //=====user
        getMember: (state) => state.member,
        getId: (state) => state.id,

        emps(state) {
            return state.emps;
        },
        emp(state) {
            return state.emp;
        },
    },
    mutations: {
        //============user===========
        //login
        loginCh(state, paylodad) {
            state.member = paylodad;
        },
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
        //============user===========
        //login
        getlogin(context, member) {
            axios.post('/user/login' + member).then(({ data }) => {
                context.commit('loginCh', data);
            });
        },
        //===========================
        getEmps({ commit }) {
            axios.get('/userList').then(({ data }) => {
                commit('setEmps', data);
                //커밋으로 뮤테이션을 부른다
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
