<template>
    <div class="container223" style="max-width=2000px">
        <div class="ms"></div>
        <div class="maparea" id="map"></div>

        <!-- <div class="resultarea" id="index_section"> -->
        <div class="choice23" style="padding-right: 0; padding-left: 10px">
            <div class="" style="font-family: 'KoHo'">
                <b class="" style="font-family: 'Do Hyeon', sans-serif; font-size: 22px"
                    >검색을 원하는 동을 골라주세요<br />
                    City:
                    <select v-model="sidocode" style="opacity: 0.6;">
                        <option v-for="sidoOption in sidoOptions" v-bind:key="sidoOption" v-bind:value="sidoOption.sido_code">
                            {{ sidoOption.sido_name }}
                        </option></select
                    ><br />
                    구군 :
                    <select v-model="guguncode" style="opacity: 0.6;">
                        <option v-for="(gOption, index) in gOptions" :key="index" :value="gOption.gugun_code">
                            {{ gOption.gugun_name }}
                        </option></select
                    ><br />
                    읍면동 :
                    <select v-model="dongcode" style="opacity: 0.6;">
                        <option v-for="(dOption, index) in dOptions" :key="index" :value="dOption.code">
                            {{ dOption.dong }}
                        </option>
                    </select>
                </b>
            </div>
            <map-searched :list-array="aptlist" :totalc="totalcode" />
        </div>
        <!-- </div> -->
    </div>
</template>

<script>
import axios from '@/util/http-common';
import MapSearched from '@/components/aptsearch/mapsearched';
export default {
    components: {
        MapSearched,
    },
    data() {
        return {
            sidocode: '',
            sidoOptions: [],
            guguncode: '',
            gOptions: [],
            dongcode: '',
            dOptions: [],
            totalcode: '',
            aptlist: [],
            //pageArray: [],
            // multi: { lat: 37.5665734, lng: 126.978179 }, //초기 센터값을 위한 멀티
        };
    },
    watch: {
        sidocode: function () {
            //alert('시도코드 변경감지');
            //guHandler();
            axios.get('/house/gugun/' + this.sidocode).then(({ data }) => {
                console.log(data);
                this.gOptions = data;
            });
        },
        guguncode: function () {
            //alert('구코드 변경감지');
            //guHandler();
            axios.get('/house/dong/' + this.sidocode + this.guguncode).then(({ data }) => {
                console.log(data);
                this.dOptions = data;
            });
        },
        dongcode: function () {
            // alert('동코드 변경감지');
            //guHandler();
            this.totalcode = this.sidocode + this.guguncode + this.dongcode;

            axios.get('/house/dongApt/' + this.totalcode).then(({ data }) => {
                console.log(data);
                // alert('아파트리스트가져옴');
                this.aptlist = data;
            });
        },
        aptlist: function () {
            // alert('aptlist 변경감지');

            return this.changeMarker(this.aptlist);
        },
    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.initMap();
        } else {
            const script = document.createElement('script');
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src = '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e5ad64ac6c3f3c7a7faca80c22f49b4b&libraries=services';
            document.head.appendChild(script);
        }

        axios.get('/house/sido').then(({ data }) => {
            console.log(data);
            this.sidoOptions = data;
        });
    },

    methods: {
        initMap() {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    //center: new kakao.maps.LatLng(37.564343, 126.947613), // 지도의 중심좌표 기본값
                    center: new kakao.maps.LatLng(37.5665734, 126.978179), // 지도의 서울역좌표
                    level: 6, // 지도의 확대 레벨
                };

            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
        },
        changeMarker(list) {
            // alert(list.length);

            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    //center: new kakao.maps.LatLng(37.564343, 126.947613), // 지도의 중심좌표 기본값
                    center: new kakao.maps.LatLng(37.5665734, 126.978179), // 지도의 서울역좌표
                    level: 6, // 지도의 확대 레벨
                };

            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';

            for (var i = 0; i < list.length; i++) {
                var imageSize = new kakao.maps.Size(24, 35);

                var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
                var lat = list[i].lat;
                //alert(lat);
                var lng = list[i].lng;
                var posi = new kakao.maps.LatLng(lat, lng);
                if (i == 0) {
                    map.panTo(posi);
                }
                //var ti = this.aptlist.aptName;
                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    map: map, // 마커를 표시할 지도
                    position: posi, // 마커를 표시할 위치
                    //title: ti, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                    image: markerImage, // 마커 이미지
                });
                marker.setMap(map);
            }
        },
    },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=KoHo:wght@700&family=Pattaya&display=swap');

.container223 {
    /* 시작을 위한 그리드 설정 */
    display: grid;
    /* 가로 10칸으로 */
    grid-template-columns: repeat(20, 1fr);
    /* 3칸으로 세로 나누기 */
    grid-template-rows: repeat(6, 1fr);
    /* overflow: inherit; */
    /* max-height: 100%; */
    margin: 0% 0%;
    background: url('../../assets/img/FF/mp.png');
    background-size: 100%;
    /* opacity: 0.8;  */
}


.maparea {
    /* 시작점은 1부터, is, js, ie, je */
    grid-column: 4 / 14;
    grid-row: 2 / 5;
    margin: 1em;

    /* max-width: 100%; */
    /* overflow: inherit; */
    /* max-height: 100%; */
}
.choice23 {
    /* 시작점은 1부터, is, js, ie, je */
    grid-column: 14 / 17;
    grid-row: 2 / 5;
    min-height: 0%;
    /* max-width: 100%; */
    /* overflow: inherit; */
    /* max-height: 100%; */
}

/* .card-body {
    margin: 0 0;
} */
</style>
