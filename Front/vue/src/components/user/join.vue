<template>
    <div>
        <div>
            <table class="table table-bordered table-condensed">
                <colgroup>
                    <col width="30%" />
                    <col width="70%" />
                </colgroup>
                <tr>
                    <th><label for="id">ID</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="id"
                            ref="id"
                            placeholder="아이디를 입력해주세요"
                            v-model="id"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="pw">PASSWORD</label></th>
                    <td>
                        <input
                            type="password"
                            class="form-control"
                            id="pw"
                            ref="pw"
                            placeholder="암호를 입력해주세요"
                            v-model="pw"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="pw">PASSWORD AGAIN</label></th>
                    <td>
                        <input
                            type="password"
                            class="form-control"
                            id="pwre"
                            ref="pwre"
                            placeholder="암호를 다시 입력해주세요"
                            v-model="pwre"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="name">NAME</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="name"
                            ref="name"
                            placeholder="이름을 입력해주세요"
                            v-model="name"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="email">E-MAIL</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="email"
                            ref="email"
                            placeholder="이메일을 입력해주세요"
                            v-model="email"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="tel">TEL</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="tel"
                            ref="tel"
                            placeholder="전화번호를 입력해주세요"
                            v-model="tel"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="address">ADDRESS</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="address"
                            ref="address"
                            placeholder="주소를 입력해주세요"
                            v-model="address"
                        />
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <button class="btn btn-primary" @click="checkHandler">
                    회원가입
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
            id: '',
            pw: '',
            pwre: '',
            name: '',
            tel: '',
            email: '',
            address: '',
        };
    },
    methods: {
        checkHandler() {
            console.log('ch of join');

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
            err &&
                !(this.pw == this.pwre) &&
                ((msg = '비밀번호가 일치하지 않습니다.'),
                (err = false),
                this.$refs.pw.focus());
            err &&
                !this.name &&
                ((msg = '이름을 입력해주세요'),
                (err = false),
                this.$refs.name.focus());
            err &&
                !this.tel &&
                ((msg = '전화번호를 입력해주세요'),
                (err = false),
                this.$refs.tel.focus());
            err &&
                !this.email &&
                ((msg = '이메일을 입력해주세요'),
                (err = false),
                this.$refs.email.focus());
            err &&
                !this.address &&
                ((msg = '주소를 입력해주세요'),
                (err = false),
                this.$refs.address.focus());

            if (!err) alert(msg);
            else this.createHandler();
        },

        createHandler() {
            console.log('cre of join');
            console.log(this.id);
            axios
                .post('/user/join', {
                    id: this.id,
                    pw: this.pw,
                    name: this.name,
                    tel: this.tel,
                    email: this.email,
                    address: this.address,
                })
                .then(({ data }) => {
                    alert('가입되었습니다.');
                    this.moveHome();
                })
                .catch(() => {
                    alert('가입실패되었습니다. 다시 시도해주세요.');
                });
        },
        moveHome() {
            // this.$router.push('/');
            this.$router.go(-1);
        },
    },
};
</script>

<style></style>
