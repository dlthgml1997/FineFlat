<template>
  <div>
    <div id="map" style="width: 600px; height: 400px; margin: auto"></div>
    아파트 디테일입니다.
    {{ $route.params.AP }}
    <br />
    {{ AP.aptName }}
  </div>
</template>

<script>

export default {
    name: 'detail-apt',
    props: {
        AP: {
            type: Array,
        },
    },
    mounted() {
        if (window.kakao && window.kakao.maps && window.kakao.maps.services) {
            this.initMap();
        } else {
            const script = document.createElement('script');
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
                '//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e5ad64ac6c3f3c7a7faca80c22f49b4b&libraries=services';
            document.head.appendChild(script);
        }
    },
    methods: {
        initMap() {
            var lat = this.AP.lat;
            var lng = this.AP.lng;
            
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(lat, lng), 
                    level: 4, // 지도의 확대 레벨
                };
            
            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
            // 마커가 표시될 위치입니다
            var markerPosition = new kakao.maps.LatLng(
                lat,
                lng
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
            marker.setMap(map);
            
            // ------------places api-----------
            var ps = new kakao.maps.services.Places(); // 장소 검색 객체를 생성합니다.
            var callback = function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    console.log(result);
                }
            };

            // 공공기관 코드 검색
            ps.categorySearch('PO3', callback, {
                // Map 객체를 지정하지 않았으므로 좌표객체를 생성하여 넘겨준다.
                location: new kakao.maps.LatLng(lat, lng)
            }).then();
        },
    },
};
</script>

<style></style>
