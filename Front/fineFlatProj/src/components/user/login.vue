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
                        <input type="text" class="form-control" id="id" ref="id" placeholder="아이디" v-model="id" />
                    </td>
                </tr>
                <tr>
                    <th><label for="pw">암호</label></th>
                    <td>
                        <input type="password" class="form-control" id="pw" ref="pw" placeholder="암호" v-model="pw" />
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <button class="btn btn-primary" @click="checkHandler">로그인</button>
                <button class="btn btn-primary" @click="moveHome">뒤로가기</button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from '@/util/http-common';

export default {
    data() {
        return {
            id: '',
            pw: '',
        };
    },

    methods: {
        checkHandler() {
            let err = true;
            let msg = '';

            !this.id && ((msg = '아이디를 입력해주세요'), (err = false), this.$refs.id.focus());
            err && !this.pw && ((msg = '비밀번호를 입력해주세요'), (err = false), this.$refs.pw.focus());

            if (!err) alert(msg);
            else this.loginRequest();
        },

        loginRequest() {
            const id = this.id;
            const pw = this.pw;
            const member = { id: this.id, pw: this.pw };
            axios({ url: '/user/login', method: 'post', data: member }).then(({ data }) => {
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
                    alert(JSON.parse(sessionStorage.getItem('user')).id + '님 환영합니다.');
                    this.moveHome();
                }
            });
        },
        moveHome() {
            // this.$router.push('/');
            alert('홈으로 돌아갑니다.');
            // this.$store.dispatch('getSh',false); 
            // this.$router.go(-1);
            document.location.reload();
        },
    },
};
</script>

<style></style>
