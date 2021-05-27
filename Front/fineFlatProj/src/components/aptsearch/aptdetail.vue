<template>
    <div class="con">
        <div class="maparea12" id="map" style="width: 100%; height: 100%"></div>
        <v-radar class="radararea" style="aling: center" :stats="stats" :polycolor="polycolor" :radar="radar" :scale="scale"> </v-radar>
        <div class="rainfoarea" style="text-align: center; font-size: 20px">
            <b>평가 점수 </b>
            <br />
            편의 : {{ stats[0].value }} | 교육 : {{ stats[1].value }} | 문화 : {{ stats[2].value }} | 카페 : {{ stats[3].value }} <br />
            500m 이내의 지하철역 수는 {{ station }} 개 입니다. <br />
        </div>
        <div class="rainfoarea2" style="text-align: center; font-family: 'Pattaya', sans-serif">
            <b> [지역 요약]</b> <br />
            현 지역은 {{ highper }}가 높은 지역으로
            {{ highcnt }}
            {{ chosedprint }}
        </div>
        <div class="infoarea">
            <b>
            <table style="opacity: 0.9; font-size:20px;">
                <thead>
                    <tr>
                        <th>Apt</th>
                        <th>Price</th>
                        <th>Deal Year</th>
                        <th>Build</th>
                        <th>Floor</th>
                        <th>Deal date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            {{ AP.aptName }}
                        </td>
                        <td>{{ AP.dealAmount }}</td>
                        <td>{{ AP.dealYear }}</td>
                        <td>{{ AP.buildYear }}</td>
                        <td>{{ AP.floor }}</td>
                        <td>{{ AP.dealYear }}.{{ AP.dealMonth }}.{{ AP.dealDay }}</td>
                    </tr>
                </tbody>
            </table>
            </b>
        </div>
    </div>
</template>

<script>
// import axios from '@/util/http-common';
import Radar from 'vue-radar';

export default {
    components: {
        'v-radar': Radar,
    },
    props: {
        AP: {
            type: Array,
        },
    },
    data() {
        return {
            station: 0,
            bestarea: '',
            print: [
                '개의 마트, 편의점, 지하철역이 500m 인근에 있습니다. 해당 지역에 거주하게 될 경우 높은 확률로 몸무게가 증가하여 귀여워 질 수 있습니다.',
                '개의 어린이집, 학원, 학교 들이  500m 인근에 몰려있는 지역입니다. 자녀의 교육이 걱정되신다면 추천드립니다.',
                '개의 관광지와 문화시설이  500m 인근에 밀집한 구역입니다. 문화적 소양이 높은 당신에게 추천드립니다.',
                '개의 카페가  500m 인근에 밀집해 있습니다. 커피와 함께 잠시 여유를 가지기에 좋습니다.',
            ],
            highper: '',
            highcnt: '',
            chosedprint: '',
            //마트, 편의점, 지하철역          //어린이집 학원  학교  //카페  관광지  문화시설
            categories: ['MT1', 'CS2', 'SW8', 'PS3', 'AC5', 'SC4', 'CE7', 'AT4', 'CT1'],
            aCnt: 0, //편의
            bCnt: 0, //교육
            cCnt: 0, //문화
            dCnt: 0, //문화
            radar: {
                size: '500',
                viewbox: '1000',
                structure: {
                    external: {
                        // external stroke of the structure's polygon
                        strokeColor: 'rgba(0, 0, 0, 0.6)',
                        strokeWidth: '2',
                    },
                    internals: {
                        // internals stroke of the structure's polygon (one every 10%)
                        strokeColor: 'rgba(255, 255, 255, 0)', // (안보이게 처리)
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
                    name: '편의지수', // string
                    value: 0,

                    // cnt:0,
                    // value: this.stats[0].cnt * 2, // int
                },
                {
                    name: '교육지수',
                    value: 0,

                    // cnt:0,
                    // value: this.stats[1].cnt*2,
                },
                {
                    name: '문화지수',
                    value: 0,

                    // cnt:0,
                    // value: this.stats[2].cnt*2,
                },
                {
                    name: '카페지수',
                    value: 0,

                    // cnt:0,
                    // value: this.stats[3].cnt*2,
                },
            ],
            polycolor: 'rgba(250, 100, 50, .5)',
        };
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
                    var groupCode = result[0].category_group_code; //배열로 넘어오는 결과값

                    if (groupCode === 'PO3' || groupCode === 'CS2' || groupCode === 'SW8') {
                        if (groupCode === 'SW8') this.station++;
                        this.aCnt += result.length;
                    } else if (groupCode === 'PS3' || groupCode === 'SC4' || groupCode === 'AC5') {
                        this.bCnt += result.length;
                    } else if (groupCode === 'AT4' || groupCode === 'CT1') {
                        this.cCnt += result.length;
                    } else if (groupCode === 'CE7') {
                        this.dCnt += result.length;
                    }
                }
                this.stats[0].value = this.aCnt * 3;
                this.stats[1].value = this.bCnt * 3;
                this.stats[2].value = this.cCnt * 3;
                this.stats[3].value = this.dCnt * 3;
                // var maxarea = Math.max([this.aCnt,this.bCnt,this.cCnt,this.dCnt]);
                // var maxarea = Math.max(this.stats[0].value, this.stats[1].value, this.stats[2].value, this.stats[3].value);
                var maxarea = Math.max(this.aCnt, this.bCnt, this.cCnt, this.dCnt);
                if (this.aCnt == maxarea) {
                    this.bestarea = 0;
                } else if (this.bCnt == maxarea) this.bestarea = 1;
                else if (this.cCnt == maxarea) this.bestarea = 2;
                else if (this.dCnt == maxarea) this.bestarea = 3;
                this.highcnt = maxarea;
                console.log(maxarea);
                // console.log(bCnt);
                // console.log(cCnt);
                // console.log(dCnt);
                this.highper = this.stats[this.bestarea].name;
                this.chosedprint = this.print[this.bestarea];
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

<style>
.con {
    /* 시작을 위한 그리드 설정 */
    font-family: 'KoHo';
    display: grid;
    /* 가로 20칸으로 */
    grid-template-columns: repeat(20, 1fr);
    /* 3칸으로 세로 나누기 */
    grid-template-rows: repeat(12, 1fr);
    overflow: inherit;
    max-height: 100%;
    margin: 0% 0%;
    font-size: 25px;
    background: url('../../assets/img/FF/mp.png');
    background-size: 100%;
}
.maparea12 {
    /* 시작점은 1부터, is, js, ie, je */
    grid-area: 3 / 3 / 9 / 11;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
}
.radararea {
    /* 시작점은 1부터, is, js, ie, je */
    grid-area: 3 / 12 / 10 / 17;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
}
.rainfoarea {
    /* 시작점은 1부터, is, js, ie, je */
    grid-area: 3 / 17 / 5 / 21;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
}
.rainfoarea2 {
    /* 시작점은 1부터, is, js, ie, je */
    grid-area: 5 / 17 /9 / 21;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
}
.infoarea {
    /* 시작점은 1부터, is, js, ie, je */
    grid-area: 9 / 12 / 14 / 21;
    max-width: 100%;
    overflow: inherit;
    max-height: 100%;
    margin: 1em;
    opacity: 0.9;
}
</style>
