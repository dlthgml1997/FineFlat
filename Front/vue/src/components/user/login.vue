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

export default {
    data() {
        return {
            id: this.id,
            pw: this.pw,
        };
    },
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
        else this.loginHandler();
    },
    loginHandler() {
        // const params = new URL(document.location).searchParams;

        axios
            .post('/user/login', {
                userid: this.id,
                userpwd: this.pw,
            })
            .then(({ data }) => {
                alert(this.id + '님 환영합니다.');
                this.moveHome();
            })
            .catch(() => {
                alert('일치하는 회원이 없습니다.');
                this.$router.push('/user/login');
            });
    },
    moveHome() {
        this.$router.push('/');
    },
};
</script>

<style></style>
