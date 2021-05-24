<template>
    <div>
        <div id="map" style="width: 600px; height: 400px; margin: auto"></div>

        <!-- //{{ apt.code }} -->
        아파트 디테일입니다.
        {{ $route.params.AP }}
        <br />
        {{ AP.aptName }}
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    name: 'detail-apt',
    props: {
        AP: {
            type: Array,
        },
        //     apt: {
        //         type: Array,
        //     },
        //     info: {
        //         type: Array,
        //     },
    },
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.initMap();
        } else {
            const script = document.createElement('script');
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
                'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e5ad64ac6c3f3c7a7faca80c22f49b4b';
            document.head.appendChild(script);
        }
    },
    methods: {
        initMap() {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    //center: new kakao.maps.LatLng(37.564343, 126.947613), // 지도의 중심좌표 기본값
                    center: new kakao.maps.LatLng(this.AP.lat, this.AP.lng), // 지도의 서울역좌표
                    level: 6, // 지도의 확대 레벨
                };
            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
            // 마커가 표시될 위치입니다
            var markerPosition = new kakao.maps.LatLng(
                this.AP.lat,
                this.AP.lng
            );
            var imageSize = new kakao.maps.Size(24, 35);

            var imageSrc =
                'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            // // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: markerPosition,
                image: markerImage, // 마커 이미지
            });
        },
    },
};
</script>

<style></style>
