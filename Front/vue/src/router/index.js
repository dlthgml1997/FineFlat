import Vue from 'vue';
import VueRouter from 'vue-router';

import HomePage from '../components/home.vue';
import MapSearch from '../components/mapsearch.vue';
import KeySearch from '../components/keysearch.vue';
import NoticePage from '@/components/notice.vue';
import NewsPage from '@/components/news.vue';

import JoinPage from '@/components/user/join.vue';
import LoginPage from '@/components/user/login.vue';
//버전 2에서만 가능한 @별칭경로 // 상위경로 웹펙엣
Vue.use(VueRouter);

// export default router;
export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            // 요청경로로오면
            name: 'homena',
            component: HomePage,
            //컴포넌츠 연결
        },
        {
            path: '/mapsearch',
            // 요청경로로오면
            name: 'mapsearch',
            component: MapSearch,
            //컴포넌츠 연결
        },
        {
            path: '/keysearch',
            name: 'keysearch',
            component: KeySearch,
        },
        {
            path: '/notice',
            name: 'notice',
            component: NoticePage,
        },
        {
            path: '/news',
            name: 'news',
            component: NewsPage,
        },
        {
            path: '*',
            name: 'notfound',
            component: { template: '<div>not found</div>' },
        },
        //==========user
        {
            path: '/user/join',
            name: 'join',
            component: JoinPage,
        },
        {
            path: '/user/login',
            name: 'login',
            component: LoginPage,
        },
    ],
});
