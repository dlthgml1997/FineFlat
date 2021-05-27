import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

import './assets/css/bootstrap.min.css';
import './assets/css/font-awesome.min.css';

import "./assets/css/owl.carousel.min.css";

import './assets/css/modal-video.min.css';
import './assets/css/animate.css';
import './assets/css/normalize.css';
import './style.css';
import './assets/css/responsive.css';

// import 'expose-loader?$!expose-loader?jQuery!jquery'

//for boot
// import 'expose-loader?$!expose-loader?jQuery!jquery';
// 위에서 추가했던 jQuery 밑에 코드를 작성하세요
// import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

Vue.use(BootstrapVue);
Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');
