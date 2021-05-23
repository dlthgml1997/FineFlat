<template>
    <div>
        <div>
            <table class="table table-bordered table-condensed">
                <colgroup>
                    <col width="30%" />
                    <col width="70%" />
                </colgroup>
                <tr>
                    <th><label for="id">아이디</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="id"
                            ref="id"
                            placeholder="아이디"
                            v-model="id"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="pw">암호</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="pw"
                            ref="pw"
                            placeholder="암호"
                            v-model="pw"
                        />
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <button class="btn btn-primary" @click="checkHandler">
                    로그인
                </button>
                <button class="btn btn-primary" @click="moveHome">
                    뒤로가기
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from '@/util/http-common';
// import { mapGetters } from 'vuex';

export default {
    data() {
        return {
            id: '',
            pw: '',
            // getId: '',
        };
    },
    // computed: {
    //     ...mapGetters('getId'),
    // },
    methods: {
        checkHandler() {
            let err = true;
            let msg = '';

            !this.id &&
                ((msg = '아이디를 입력해주세요'),
                (err = false),
                this.$refs.id.focus());
            err &&
                !this.pw &&
                ((msg = '비밀번호를 입력해주세요'),
                (err = false),
                this.$refs.pw.focus());

            if (!err) alert(msg);
            else this.loginRequest();
        },

        loginRequest() {
            const id = this.id;
            const pw = this.pw;
            const member = { id: this.id, pw: this.pw };
            axios({ url: '/user/login', method: 'post', data: member }).then(
                ({ data }) => {
                    console.log('얻데');
                    console.log(data);
                    this.member = data;
                    console.log(member);
                    if (!data) {
                        alert('올바르지 않습니다.');
                    } else {
                        //alert('로그인');
                        //localStorage.setItem('user',data);
                        const tm = { id: 1, pw: 2 };
                        //sessionStorage.setItem('tmp', tm);
                        sessionStorage.setItem('user', JSON.stringify(data));
                        alert(JSON.parse(sessionStorage.getItem('user')).id+'님 환영합니다.');
                        this.moveHome();
                    }
                    // context.commit('loginCh', data);
                    //return data.id;
                }
            );
        },

        // const params = new URL(document.location).searchParams;
        //스토어에 겟 로그인 액션을 콜
        // return new Promise(
        //     resolve =>{

        //     }
        //     (resolve,reject )=>{
        //     console.log('로그인 시도');
        //     this.$store.dispatch('getlogin',this.id, this.pw);
        //     resolve();
        // })
        // try {
        //     console.log('트라이');
        //     const response = await loginReq(this.id, this.pw);
        //     console.log(response);
        //     return response;
        // } catch (error) {}
        // this.$store
        //     .dispatch('getlogin', {
        //         id: this.id,
        //         pw: this.pw,
        //     })
        //     .then(function (response) {
        //         console.log('돌');
        //         console.log(this.id);
        //         console.log('memberid');
        //         console.log(this.getId);
        //     });

        // if (!this.id) {
        //     alert('다시 입력해주세요.');
        // } else {
        //     alert(this.id + '님 환영합니다.');
        //     //this.moveHome();
        // }

        // axios
        //     .post('/user/login', {
        //         id: this.id,
        //         pw: this.pw,
        //     })

        //     .then(({ data }) => {
        //         console.log(data);
        //         // this.$store.dispatch('getlogin');
        //         // alert(this.member.id + '환영합니다.');
        //         this.moveHome();
        //     });
        // // .catch(() => {
        // //     alert('일치하는 회원이 없습니다.');
        // //     this.$router.push('/user/login');
        // // });
        //},
        // loginReq(id, pw) {
        //     console.log(id);
        //     return this.$store.dispatch('getlogin', { id, pw });
        // },
        moveHome() {
            // this.$router.push('/');
            alert('홈으로 돌아갑니다.');
            this.$router.go(-1);
        },
    },
};
</script>

<style></style>
