import Vue from 'vue';
import VueRouter from 'vue-router';
//home
import HomePage from '../components/navi/home.vue';
//user
import JoinPage from '@/components/user/join.vue';
import LoginPage from '@/components/user/login.vue';
import MyPage from '@/components/user/mypage.vue';
// //apt
import AptDetailPage from '@/components/aptsearch/aptdetail.vue';
import KeySearch from '../components/aptsearch/keysearch.vue';
import MapSearch from '../components/aptsearch/mapsearch.vue';
// //noticeboard
import NoticePage from '@/components/notice/noticemain.vue';
import ArticleDetailPage from '@/components/notice/articledetail.vue';
import ArticleModi from '@/components/notice/articlemodi.vue';
import ArticleWrite from '@/components/notice/articlewrite.vue';

import NewsPage from '@/components/news/news.vue';
//버전 2에서만 가능한 @별칭경로 // 상위경로 웹펙엣
Vue.use(VueRouter);

// export default router;
export default new VueRouter({
    mode: 'history',
    routes: [
        //=========navi page
        {
            // 홈페이지
            path: '/',
            name: 'home',
            component: HomePage,
        },
        {
            path: '*',
            name: 'notfound',
            component: { template: '<div>not found</div>' },
        },
        // ===========user
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
        {
            path: '/user/mypage',
            name: 'mypage',
            component: MyPage,
        },
        //==========apt search
        {
            //맵겁색 결과의 디테일 페이지
            path: '/apt/aptdetail',
            name: 'AptDetail',
            component: AptDetailPage,
            props: true,
        },
        {
            // 맵검색
            path: '/mapsearch',
            name: 'mapsearch',
            component: MapSearch,
        },
        {
            // 아파트 명으로 검색
            path: '/keysearch',
            name: 'keysearch',
            component: KeySearch,
        },
        // //==========board
        {
            path: '/noticemain',
            name: 'noticemain',
            component: NoticePage,
        },
        {
            path: '/notice/articlemodi/aticeaticledetail',
            name: 'ArticleDetail',
            component: ArticleDetailPage,
            props: true,
        },
        {
            path: '/notice/articlemodi',
            name: 'articlemodi',
            component: ArticleModi,
            props: true,
        },
        {
            path: '/notice/articlewrite',
            name: 'articlewrite',
            component: ArticleWrite,
            props: true,
        },
        //===========news
        {
            path: '/news',
            name: 'news',
            component: NewsPage,
        },
    ],
});
