<template>
    <html lang="en">
        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <meta http-equiv="X-UA-Compatible" content="ie=edge" />
            <title>Misocial - HTML5 Template</title>
        </head>

        <body>
            <!-- Start Header area
======================================-->
            <!-- 첫페이지 잡는 디브 -->
            <!-- <div class="header-area"> -->
            <div style="height: 7vh"></div>
            <div class="header-">
                <div class="container">
                    <div class="">
                        <nav
                            class="navbar navbar-expand-lg navbar-light fixed-top"
                            style="background: rgb(139,158,217); font-family: 'KoHo'; sans-serif; height:7vh; position:absolute"
                        >
                            <!-- <navi-bar></navi-bar> 대신 하단 직접 입력 -->
                            <!-- 로고 버튼 -->
                            <div class="">
                                <img src="./assets/img/FF/LGF.png" width="40%" alt="" class="logo" height="90%" style="margin: 0 1em" />
                            </div>
                            <!-- 네비 버튼들 -->
                            <div class="collapse navbar-collapse my-1 my-lg-0" id="navbarSupportedContent1" style="color: white">
                                <!-- <div class="mainmenu" style="height: 10vh"> -->
                                <ul class="navbar-nav ml-auto">
                                    <li class="nav-item">
                                        <div @click="movehome" style="padding: 0 1em; color: white; font-size: 20px; font-family: 'KoHo'">HOME</div>
                                        <!-- <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a> -->
                                    </li>

                                    <template v-if="loginCheck()">
                                        <li class="nav-item">
                                            <button class="bt log" @click="openModal" style="padding: 0 0.5em 0 0; color: white; font-family: 'KoHo'">
                                                Log IN
                                            </button>
                                            <user-modal v-if="showmodal" @close="showmodal = false">
                                                <h2 slot="header" style="font-family: 'KoHo'">
                                                    WELLCOME TO <b>FINE FLAT</b>
                                                    <i class="fas" @click="showmodal = false"></i>
                                                </h2>
                                                <div slot="body">
                                                    <log-area> </log-area>
                                                </div>
                                            </user-modal>
                                        </li>

                                        <li class="nav-item">
                                            <button
                                                class="bt join"
                                                @click="joinopenModal"
                                                style="padding: 0 0.5em 0 0; color: white; font-family: 'KoHo'"
                                            >
                                                JOIN
                                            </button>
                                            <join-modal v-if="joinshowmodal" @close="joinshowmodal = false">
                                                <h2 slot="header" style="font-family: 'KoHo'">
                                                    JOIN TO <b>FINE FLAT</b>
                                                    <i class="fas" @click="joinshowmodal = false"></i>
                                                </h2>
                                                <div slot="body">
                                                    <join-area> </join-area>
                                                </div>
                                            </join-modal>
                                        </li>
                                    </template>
                                    <template v-else>
                                        <li class="nav-item">
                                            <div
                                                @click="mapmove"
                                                style="padding: 0 1em; color: black; font-family: 'KoHo'; color: white; font-size: 20px"
                                            >
                                                in MAP
                                            </div>

                                            <!-- <a class="nav-link" href="whymisocial.html">Why MISCOIAL</a> -->
                                        </li>
                                        <li class="nav-item">
                                            <div
                                                @click="keysearch"
                                                style="padding: 0 1em; color: black; font-family: 'KoHo'; color: white; font-size: 20px"
                                            >
                                                by APT-NAME
                                            </div>
                                            <!-- <a class="nav-link" href="feature.html">Features</a> -->
                                        </li>
                                        <li class="nav-item">
                                            <div
                                                @click="noticemain"
                                                style="padding: 0 1em; color: black; font-family: 'KoHo'; color: white; font-size: 20px"
                                            >
                                                NOTICE
                                            </div>

                                            <!-- <a class="nav-link" href="pricing.html">Pricing</a> -->
                                        </li>
                                        <li
                                            class="nav-item"
                                            style="padding: 0 1em; font-size: 20px; font-family: 'KoHo'; color: rgb(50, 44, 88); font-family: 'KoHo'"
                                        >
                                            HELLO ! [{{ id }}]
                                        </li>
                                        <li class="nav-item">
                                            <button
                                                class="bt btn1"
                                                style="padding: 0 1em; font-family: 'KoHo'; color: white; margin: 0"
                                                @click="moveMypage()"
                                            >
                                                MY Page
                                            </button>
                                        </li>
                                        <li class="nav-item">
                                            <button
                                                class="bt btn1"
                                                style="padding: 0 1em; font-family: 'KoHo'; color: white; margin: 0"
                                                @click="logoutHandler()"
                                            >
                                                Log Out
                                            </button>
                                        </li>
                                    </template>
                                </ul>
                                <!-- </div> -->
                            </div>
                        </nav>
                        <!--End of nav bar-->
                    </div>
                </div>
                <!--End of Container-->
                <a v-if="pge" href="#section1" class="scrl-down scroll-down"><i class="fa fa-long-arrow-down"></i></a>
            </div>
            <template v-if="!loginCheck()">
                <div>
                    <router-view style="overflow: inherit; height: 93vh"></router-view>
                </div>
            </template>
            <template v-else>
                <home></home>
            </template>
            <!--End of header area-->

            <!-- Why Choose us
======================================-->
            <div v-if="pge" id="section1" class="choose-us">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-6">
                            <div class="team-title">
                                <h6>our team</h6>
                                <h1>Meet the team</h1>
                                <p>
                                    Samsung software academy for youth 5th Seoul 11 Calss. We Create Web site for find good Apt using SpringBoot and
                                    Vuejs.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="m-height-80"></div>
                    <div class="row">
                        <div class="col-lg-3 col-sm-6 col-12">
                            <div class="single-team-box">
                                <img src="./assets/img/FF/jj.png" width="220px" height="300px" alt="" class="img-fluid" />
                                <div class="teams-title"></div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-12">
                            <div class="single-team-box">
                                <div class="teams-title">
                                    <h4>[JANGSEOP LEE]</h4>
                                    <p>"간절히 원하고, 꾸준히 버티기"</p>
                                    <h6>한국산업기술대학교</h6>
                                    <h6>메카트로닉스공학과</h6>
                                    <h6>JAVA, Vuejs, Javascript</h6>
                                    <p>Art Director</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-12">
                            <div class="single-team-box">
                                <img src="./assets/img/FF/so.png" width="220px" height="300px" alt="" class="img-fluid" />
                                <div class="teams-title"></div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6 col-12">
                            <div class="single-team-box">
                                <div class="teams-title">
                                    <h4>[SOHEE LEE]</h4>
                                    <p>"고민보다는 도전"</p>
                                    <h6>한성대학교</h6>
                                    <h6>IT응용시스템공학과</h6>
                                    <h6>JAVA, SPRING, ANDROID</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End of row-->
                </div>
                <!--End of Container-->
            </div>
            <!--End of team area-->
            <!--End of Team-->

            <!-- Footer Area
======================================-->
            <div class="footer-menu">
                <a href="" class="logo-footer"><img src="./assets/img/FF/lo.png" width="4%" alt="" /></a>
                <p>© 2021 SSAFY 1ST SEMESTER FINAL PROJECT &amp; LEE JAGN SEOP &amp; LEE SOO HEE</p>

                <!--End of container fluid-->
                <a href="#" class="back-to-top"><i class="fa fa-long-arrow-up"></i></a>
            </div>
            <!--End of Footer Menu-->

            <!-- <script src="./assets/js/popper.min.js"></script>
	<script src="./assets/js/bootstrap.min.js"></script>
	<script src="./assets/js/owl.carousel.min.js"></script>
	<script src="./assets/js/modal-video.js"></script> -->
            <!-- <script src="./assets/js/main.js"></script> -->
        </body>
    </html>
</template>

<!-- <div id="app">
            <div id="nav"> -->
<!-- 탑헤더 컴포넌트를 임폴트 해와서 띄워준다 -->
<!-- <top-header></top-header> -->
<!-- 네비바 컴포넌트를 임폴트 해와서 띄워준다 -->
<!-- <navi-bar></navi-bar>
            </div>
        </div> -->

<!-- <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
        <script src="./assets/js/owl.carousel.min.js"></script>
        <script src="./assets/js/modal-video.js"></script>
        <script src="./assets/js/main.js"></script> -->

<script>
// import TopHeader from '@/components/navi/topheader.vue';
import NaviBar from '@/components/navi/navibar.vue';

// import popper from './assets/js/popper.min.js';
// import min from './assets/js/bootstrap.min.js';
// import owl from './assets/js/owl.carousel.min.js';
// import modal from './assets/js/modal-video.js';
// import mains from './assets/js/main2.js';

// import HomeHome from '@/components/navi/home.vue';
import UserModal from '@/components/modal/lognjoinmodal.vue';
import JoinModal from '@/components/modal/joinmodal.vue';
import LogArea from '@/components/user/login.vue';
import JoinArea from '@/components/user/join.vue';
import Home from './components/navi/home.vue';
// import Usermodal from './components/modal/usermodal.vue';
// import { mapGetters } from 'vuex';

export default {
    name: 'mainpage',
    components: {
        // TopHeader,
        NaviBar,

        UserModal,
        JoinModal,

        LogArea,
        JoinArea,

        stagecom: 0,
    
        Home},
    computed: {
        // ...mapGetters(['showmodal']),
    },
    data() {
        return {
            modal: false,
            message: '',
            pge: true,
            showmodal: false,
            joinshowmodal: false,
        };
    },
    methods: {
        addScript: function () {
            let scripts = [
                // '././public/bootstrap.min.js',
                // '././public/popper.min.js',
                // '././public/owl.carousel.min.js',
                // '././public/modal-video.js',
                // '././public/main.js',
            ];

            for (let i = 0, len = scripts.length; i < len; i++) {
                let script = document.createElement('script');
                script.setAttribute('type', 'text/javascript');
                script.setAttribute('src', scripts[i]);
                script.async = true;
                document.getElementsByTagName('body or head')[0].appendChild(script);
            }
        },

        openModal() {
            // this.$store.dispatch('getSh',true);
            // this.$store.commit('setSh',true);
            this.showmodal = true;
        },
        joinopenModal() {
            // this.$store.dispatch('getSh',true);
            // this.$store.commit('setSh',true);
            this.joinshowmodal = true;
        },
        closeModal() {
            // this.$store.commit('setSh',false);
            // this.$store.dispatch('getSh',false);
            this.showmodal = false;
        },
        joincloseModal() {
            // this.$store.commit('setSh',false);
            // this.$store.dispatch('getSh',false);
            this.joinshowmodal = false;
        },
        doSend() {
            if (this.message.length > 0) {
                alert(this.message);
                this.message = '';
                this.closeModal();
            } else {
                alert('메시지를 입력해주세요.');
            }
        },
        loginCheck() {
            if (!sessionStorage.getItem('user')) {
                //로그인 유저가 없다면
                return true;
            } else {
                this.id = JSON.parse(sessionStorage.getItem('user')).id;
                return false;
            }
        },
        logoutHandler() {
            sessionStorage.removeItem('user');
            alert('안녕히가세요');
            this.$router.push('/');
            location.reload();
        },
        moveMypage() {
            this.pge = false;
            this.$router.push('/user/mypage');
        },
        mapmove() {
            this.pge = false;
            this.$router.push('/mapsearch');
        },
        keysearch() {
            this.pge = false;
            this.$router.push('/keysearch');
        },
        noticemain() {
            this.pge = false;
            this.$router.push('/noticemain');
        },
        movehome() {
            this.pge = true;
            this.$router.push('/');
        },
    },
    created() {
        this.addScript();
    },
};
</script>

<style>
/* @import url('https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'); */
/* @import './style.css'; */
@import './assets/css/bootstrap.min.css';
@import './assets/css/font-awesome.min.css';

@import './assets/css/owl.carousel.min.css';
@import './assets/css/modal-video.min.css';
@import './assets/css/animate.css';
@import './assets/css/normalize.css';
@import './style.css';
@import './assets/css/responsive.css';

@import url('https://fonts.googleapis.com/css2?family=KoHo:wght@700&family=Pattaya&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=KoHo:wght@700&family=Pattaya&display=swap');
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
.mainmenu li {
    display: inline-block;
    position: relative;
    z-index: 3;
    margin: 0 10px;
}

#nav {
    padding: 30px;
}

#nav a {
    font-weight: bold;
    color: #2c3e50;
}

#nav a.router-link-exact-active {
    color: #42b983;
}

.table {
    width: 100%;
    margin: 20px auto;
    text-align: center;
}
th {
    background-color: #4d6bb3;
    color: blue;
}

router-link {
    color: blue;
}

.container {
    max-width: 1640px;
}
.bt {
    background: #4618b1;
    color: rgb(3, 2, 2);
    border: none;
    position: relative;
    height: 30px;
    font-size: 100%;
    padding: 0 1em;
    cursor: pointer;
    margin: 0em;
    transition: 800ms ease all;
    outline: none;
    border-radius: 25%;
    font-family: 'KoHo', sans-serif;
}
.bt:hover {
    background: rgb(221, 75, 221);
    color: #1316cf;
}
.bt:before,
.bt:after {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    height: 2px;
    width: 0;
    background: #1316cf;
    transition: 400ms ease all;
}
.bt:after {
    right: inherit;
    top: inherit;
    left: 0;
    bottom: 0;
}
.bt:hover:before,
.bt:hover:after {
    width: 100%;
    transition: 800ms ease all;
}
</style>
