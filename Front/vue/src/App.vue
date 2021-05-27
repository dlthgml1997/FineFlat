<template>
    <!-- <html> -->
        <!-- <head>
            <meta charset="UTF-8" />
            <meta
                name="viewport"
                content="width=device-width, initial-scale=1.0"
            />
            <meta http-equiv="X-UA-Compatible" content="ie=edge" />
            <title>Misocial - HTML5 Template</title>
            <link rel="stylesheet" href="./assets/css/bootstrap.min.css" />
            <link rel="stylesheet" href="./assets/css/font-awesome.min.css" />
            <link rel="stylesheet" href="./assets/css/owl.carousel.min.css" />
            <link rel="stylesheet" href="./assets/css/modal-video.min.css" />
            <link rel="stylesheet" href="./assets/css/animate.css" />
            <link rel="stylesheet" href="./assets/css/normalize.css" />
            <link rel="stylesheet" href="./style.css" />
            <link rel="stylesheet" href="./assets/css/responsive.css" />

            <script src="./assets/js/jquery.3.2.1.min.js"></script>
        </head> -->
        <!-- <nav class="navbar navbar-expand-lg navbar-light fixed-top">
            <a class="navbar-brand" href=""
                ><img src="./assets/img/logo.png" alt="" class="logo"
            /></a>
            <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>

            <div
                class="collapse navbar-collapse my-2 my-lg-0"
                id="navbarSupportedContent"
            >
                <div class="mainmenu">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href=""
                                >Home <span class="sr-only">(current)</span></a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href=""
                                >Why MISCOIAL</a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Features</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false"
                                >Articles</a
                            >
                            <div
                                class="dropdown-menu"
                                aria-labelledby="navbarDropdown"
                            >
                                <a class="dropdown-item" href=""
                                    >Blog</a
                                >
                                <a class="dropdown-item" href=""
                                    >Single Blog</a
                                >
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Pricing</a>
                        </li>
                        <li class="getstart">
                            <a class="active" href=""
                                >get started</a
                            >
                        </li>
                    </ul>
                </div>
            </div>
        </nav> -->

        <div id="app">
            <div id="nav">
                <!-- 탑헤더 컴포넌트를 임폴트 해와서 띄워준다 -->
                <top-header></top-header>
                <!-- 네비바 컴포넌트를 임폴트 해와서 띄워준다 -->
                <navi-bar></navi-bar>
            </div>
        </div>
    <!-- </html> -->
</template>
<script>
import TopHeader from '@/components/navi/topheader.vue';
import NaviBar from '@/components/navi/navibar.vue';

export default {
    name: 'mainpage',
    components: {
        TopHeader,
        NaviBar,
    },
};
</script>

<style>
@import url('https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css');
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
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
    color: white;
}
</style>
