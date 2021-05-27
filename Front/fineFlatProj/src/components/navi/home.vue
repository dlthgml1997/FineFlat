<template class="backhome">
    <div style="text-align: center">
        <video muted autoplay loop>
            <source src="./../../assets/video/planet.mp4" type="video/mp4" />
        </video>
        <div class="top1">
            <br />
            <br />
            <br />
            <h2 style="font-family: 'Pattaya', sans-serif">What a Wonderful Life ! It's come from House ! Find you Fine house in</h2>
            <h2
                style="
                    font-family: 'Pattaya', sans-serif;
                    font-size: 120px;
                    color: rgb(50, 79, 193);
                    text-shadow: -1px 0 pink, 0 1px pink, 1px 0 pink, 0 -1px pink;
                "
            >
                FINE FLAT
            </h2>
            <h6>당신의 라이프를 바꿔 줄 집을 찾아드립니다.</h6>
        </div>
        <table class="top" v-if="!loginCheck()">
            <thead>
                <tr>
                    최신 조회 top 5
                </tr>
                <tr style="back">
                    <th>Dong</th>
                    <th>Apt</th>
                    <th>Price</th>
                    <th>Deal Year</th>
                    <th>Build</th>
                    <th>Floor</th>
                    <th>Deal date</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="apt in list" :key="apt">
                    <td>{{ apt.dong }}</td>
                    <td>{{ apt.aptName }}</td>
                    <td>{{ apt.dealAmount }}</td>
                    <td>{{ apt.dealYear }}</td>
                    <td>{{ apt.buildYear }}</td>
                    <td>{{ apt.floor }}</td>
                    <td>{{ apt.dealYear }}.{{ apt.dealMonth }}.{{ apt.dealDay }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    data: function () {
        return {
            id: '',
            list: [],
        };
    },
    mounted() {
        // this.$store.dispatch()
        axios
            .get('/house/mostclicked')
            .then(({ data }) => {
                console.log(data);
                this.list = data;
            })
            .catch(() => {
                alert('에러가 발생했습니다.');
            });
        this.loginCheck();
    },
    methods: {
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
            location.reload();
        },
        moveMypage() {
            this.$router.push('/user/mypage');
        },
    },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=KoHo:wght@700&family=Pattaya&display=swap');
.backhome {
    /* background-image: url('./../../assets/img/811.png'); */
    /* background: url('./assets/811.png');
    background-size: 100%; */
    width: 100%;
    height: 500px;
    overflow: hidden;
    margin: 0px auto;
    position: relative;
}
video {
    width: 100%;
}
.top {
    position: absolute;
    top: 50%;
    width: 70%;
    margin-top: -24px;
    margin-left: 9cm;
    text-align: center;
    font-size: 48px;
    color: #0e0707;
    align-items: center;
    font-size: 35px;
    font-style: initial;
    font-family: 'Pattaya', sans-serif;
}
.top1 {
    position: absolute;
    top: 10%;
    width: 70%;
    margin-top: -24px;
    margin-left: 9cm;
    text-align: center;
    font-size: 48px;
    color: #fafafa;
    align-items: center;
    font-size: 35px;
    font-style: initial;
    font-family: 'Pattaya', sans-serif;
}
</style>
