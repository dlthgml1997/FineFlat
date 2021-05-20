import Vue from 'vue';
import VueRouter from 'vue-router';
import EmpRegist from '../components/regist.vue';
import EmpList from '../components/list.vue';
import EmpDetail from '@/components/detail.vue';
//버전 2에서만 가능한 @별칭경로 // 상위경로 웹펙엣
Vue.use(VueRouter);

// export default router;
export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/detail',
            // 요청경로로오면
            name: 'datail',
            component: EmpDetail,
            //컴포넌츠 연결
        },
        {
            path: '/list',
            name: 'list',
            component: EmpList,
        },
        {
            path: '/regist',
            name: 'regist',
            component: EmpRegist,
        },
        {
            path: '*',
            name: 'notfound',
            component: { template: '<div>not found</div>' },
        },
    ],
});
