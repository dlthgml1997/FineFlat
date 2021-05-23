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
        Sid: '',
        errorState: '',
        isAuth: false,
        member: { id: '', pw: '' },
        //=====
        emps: [],
        emp: {},
    },
    getters: {
        //=====user
        // getId: (state) => {
        //     console.log('getme');
        //     console.log(state.Sid);
        //     return state.Sid;
        // },

        // // getId: (state) => state.id,

        // emps(state) {
        //     console.log('getme');
        //     return state.emps;
        // },
        // emp(state) {
        //     return state.emp;
        // },
    },
    mutations: {
        //============user===========
        //login
        loginCh(state, paylodad) {
            console.log('paylodad');
            console.log(paylodad);
            state.Sid = paylodad.id;
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
        async getlogin(context, { id, pw }) {
            console.log('겟로');
            console.log(id, pw);
            axios.post('/user/login', { id, pw }).then(({ data }) => {
                console.log('얻데');
                console.log(data);
                context.commit('loginCh', data);
                return data.id;
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
