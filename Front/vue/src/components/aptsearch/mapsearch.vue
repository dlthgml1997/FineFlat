<template>
  <div class="container">
    <div>지도검색페이지</div>
    <div id="map" style="width: 600px; height: 400px; margin: auto"></div>
    <section id="index_section">
      <div class="card col-sm-12 mt-1" style="min-height: 850px">
        <div class="card-body">
          시도 :
          <select v-model="sidocode">
            <option
              v-for="sidoOption in sidoOptions"
              v-bind:key="sidoOption"
              v-bind:value="sidoOption.sido_code"
            >
              {{ sidoOption.sido_name }}
            </option>
          </select>
          구군 :
          <select v-model="guguncode">
            <option v-for="(gOption, index) in gOptions" :key="index" :value="gOption.gugun_code">
              {{ gOption.gugun_name }}
            </option>
          </select>
          읍면동 :
          <select v-model="dongcode" class="mb-2">
            <option v-for="(dOption, index) in dOptions" :key="index" :value="dOption.code">
              {{ dOption.dong }}
            </option>
          </select>
          <map-searched :list-array="aptlist" :totalc="totalcode" />
        </div>
      </div>
    </section>
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
      //guHandler();
      axios.get('/house/gugun/' + this.sidocode).then(({ data }) => {
        console.log(data);
        this.gOptions = data;
      });
    },
    guguncode: function () {
      //guHandler();
      axios.get('/house/dong/' + this.sidocode + this.guguncode).then(({ data }) => {
        console.log(data);
        this.dOptions = data;
      });
    },
    dongcode: function () {
      //guHandler();
      this.totalcode = this.sidocode + this.guguncode + this.dongcode;

      axios.get('/house/dongApt/' + this.totalcode).then(({ data }) => {
        console.log(data);
        this.aptlist = data;
      });
    },
    aptlist: function () {
      return this.changeMarker(this.aptlist);
    },
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e5ad64ac6c3f3c7a7faca80c22f49b4b&libraries=services';
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

      // 마커 이미지를 생성합니다
      // 마커가 표시될 위치입니다
      // var markerPosition = new kakao.maps.LatLng(37.5665734, 126.978179);

      // // 마커를 생성합니다
      // var marker = new kakao.maps.Marker({
      //     position: markerPosition,
      // });
      // // 마커가 지도 위에 표시되도록 설정합니다
      // axios.get('/house/gugun' + this.sidocode).then(({ data }) => {
      //     console.log(data);
      //     this.gOptions = data;
      // });
    },
  },
};
</script>

<style></style>
