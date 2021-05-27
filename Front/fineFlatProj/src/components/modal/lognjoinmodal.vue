<template>
    <transition name="modal" appear>
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container1">
                    <div class="modal-header">
                        <slot name="header">헤더</slot>
                    </div>
                    <div class="modal-body">
                        <slot name="body"> </slot>
                    </div>
                    <div class="modal-footer">
                        <slot name="footer">
                            <!-- <button class="modal-button" @click="$emit('close')">클버튼</button> -->
                        </slot>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div class="modal-overlay" @click.self="$emit('close')">
            <div class="modal-window">
                <div class="modal-content">
                    모달창입니다.
                    <slot />
                </div>
                <footer class="modal-footer">
                    <slot name="footer">
                        <button @click="$emit('close')">Close</button>
                    </slot>
                </footer>
            </div>
        </div> -->
    </transition>
</template>

<style>
.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(199, 13, 13, 0.5);
    display: table;
    transition: opacity 0.3s ease;
}

.modal-wrapper {
    display: table-cell;
    vertical-align: middle;
}

.modal-container1 {
    width: 50%;
    margin: 0px auto;
    padding: 20px 30px;
    background-color: rgba(116, 185, 156, 0.925);
    border-radius: 2px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
    transition: all 0.3s ease;
    font-family: Helvetica, Arial, sans-serif;
    border-radius: 20px;
}

.modal-header h3 {
    margin-top: 0;
    color: #42b983;
}

.modal-body {
    margin: 20px 0;
}

.modal-default-button {
    float: right;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
    opacity: 0;
}

.modal-leave-active {
    opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
    -webkit-transform: scale(1.1);
    transform: scale(1.1);
}
</style>
