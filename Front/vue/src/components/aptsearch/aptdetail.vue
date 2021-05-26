<template>
  <div>
    <div id="map" style="width: 600px; height: 400px; margin: auto"></div>
    아파트 디테일입니다.
    {{ $route.params.AP }}
    <br />
    <v-radar :stats="stats" :polycolor="polycolor" :radar="radar" :scale="scale"> </v-radar>
  </div>
</template>

<script>
import Radar from 'vue-radar';

export default {
  name: 'detail-apt',
  components: {
    'v-radar': Radar,
  },
  data() {
    return {
      categories: ['MT1', 'CS2', 'SW8', 'PS3', 'AC5', 'SC4', 'CE7', 'AT4', 'CT1'],
      aCnt: 0,
      bCnt: 0,
      cCnt: 0,
      radar: {
        size: '500',
        viewbox: '1000',
        structure: {
          external: {
            // external stroke of the structure's polygon
            strokeColor: 'rgba(0, 0, 0, 0.6)', // color (any css format is usable (hexa, rgb, rgba...))
            strokeWidth: '2', // pixel unit
          },
          internals: {
            // internals stroke of the structure's polygon (one every 10%)
            strokeColor: 'rgba(255, 255, 255, .2)', // color (any css format is usable (hexa, rgb, rgba...))
            strokeWidth: '1', // pixel unit
          },
          average: {
            // average polygon (placed at 50%)
            strokeColor: 'rgba(255, 255, 255, 1)', // stroke color (any css format is usable (hexa, rgb, rgba...))
            strokeWidth: '2', // pixel unit
            fillColor: 'rgba(0, 0, 0, 0.1)', // polygon color (any css format is usable (hexa, rgb, rgba...))
          },
        },
      }, // empty object is mandatory
      scale: {}, // empty object is mandatory
      stats: [
        // at least 3 stats are required here
        {
          name: '편의', // string
          value: 0, // int
        },
        {
          name: '교육',
          value: 0,
        },
        {
          name: '문화',
          value: 0,
        },
      ],
      polycolor: 'rgba(250, 100, 50, .5)',
    };
  },
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
      var markerPosition = new kakao.maps.LatLng(lat, lng);
      var imageSize = new kakao.maps.Size(24, 35);

      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png';
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

      // // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        map: map,
        position: markerPosition,
        image: markerImage, // 마커 이미지
      });
      marker.setMap(map);
      this.categorySearch(lat, lng);
    },
    categorySearch(lat, lng) {
      for (let i = 0; i < this.categories.length; i++) {
        this.searchEachCategory(this.categories[i], lat, lng);
      }
    },
    searchEachCategory(data, lat, lng) {
      var ps = new kakao.maps.services.Places(); // 장소 검색 객체를 생성합니다.

      var callback = (result, status) => {
        if (status === kakao.maps.services.Status.OK) {
          var groupCode = result[0].category_group_code;

          if (groupCode === 'PO3' || groupCode === 'CS2' || groupCode === 'SW8') {
            this.aCnt += result.length * 2;
          } else if (groupCode === 'PS3' || groupCode === 'SC4' || groupCode === 'AC5') {
            this.bCnt += result.length * 2;
          } else if (groupCode === 'CE7' || groupCode === 'AT4' || groupCode === 'CT1') {
            this.cCnt += result.length * 2;
          }
        }
        this.stats[0].value = this.aCnt;
        this.stats[1].value = this.bCnt;
        this.stats[2].value = this.cCnt;
      };

      // 공공기관 코드 검색
      var searchFunc = ps.categorySearch(data, callback, {
        // Map 객체를 지정하지 않았으므로 좌표객체를 생성하여 넘겨준다.
        location: new kakao.maps.LatLng(lat, lng), // 매물 위치 기반
        radius: 500, // 전방 500M 기준
      });
    },
  },
};
</script>

<style></style>
