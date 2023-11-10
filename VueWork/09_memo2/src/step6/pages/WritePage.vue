<template>
    <header-component title="글쓰기"></header-component> 
    <div>
        <textarea v-model="memo"></textarea>
        <div>
            <button @click="setMode(MODE.LIST)">취소</button>
            <button @click="onAddMemo()">저장</button>
        </div>
    </div>
    <br>
    <footer-component></footer-component>
</template>

<script>
import {MODE} from "../common.js"
    export default {
        data() {
            return {memo : ""}
        },
        props: {
            setMode :{
                type: Function
            },
            addMemo : {
                type: Function
            }
        },
        computed :{
            MODE(){
                return MODE;
            }
        },
        methods: {
            onAddMemo(){
                this.addMemo(this.memo);
                this.setMode(MODE.LIST);
            }
        }
    }
</script>

<style scoped>

</style>