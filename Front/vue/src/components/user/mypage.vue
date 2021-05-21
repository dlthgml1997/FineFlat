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
                            readonly,
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
                <tr>
                    <th><label for="name">이름</label></th>
                    <td>
                        <input
                            readonly,
                            type="text"
                            class="form-control"
                            id="name"
                            ref="name"
                            placeholder="이름"
                            v-model="name"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="email">이메일</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="email"
                            ref="email"
                            placeholder="이메일"
                            v-model="email"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="tel">전화번호</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="tel"
                            ref="tel"
                            placeholder="전화번호"
                            v-model="tel"
                        />
                    </td>
                </tr>
                <tr>
                    <th><label for="address">주소</label></th>
                    <td>
                        <input
                            type="text"
                            class="form-control"
                            id="address"
                            ref="address"
                            placeholder="주소"
                            v-model="address"
                        />
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <button class="btn btn-primary" @click="checkHandler">
                    수정하기
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
            name: '',
            reginum: '',
            email: '',
            address: '',
        };
    },

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
            err &&
                !this.name &&
                ((msg = '이름을 입력해주세요'),
                (err = false),
                this.$refs.name.focus());
            err &&
                !this.calnum &&
                ((msg = '전화번호를 입력해주세요'),
                (err = false),
                this.$refs.calnum.focus());
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
            axios
                .post('/user/modify', {
                    id: this.id,
                    pw: this.pw,
                    name: this.name,
                    calnum: this.calnum,
                    email: this.email,
                    address: this.address,
                })
                .then(({ data }) => {
                    alert('수정되었습니다.');
                    this.moveHome();
                });
        },
        moveHome() {
            alert("홈으로 돌아갑니다.")
            this.$router.push('/');
        },
    },
};
</script>

<style></style>
