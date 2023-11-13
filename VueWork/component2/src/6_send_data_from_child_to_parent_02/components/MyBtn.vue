<template>
    <div class="btn">
        <slot></slot>
    </div>
    <!--<h1 @click="$emit('myclk', 'emit')">Test</h1> //parameter 전달-->
    <h1 @click="$emit('myclk', $event)">Test</h1> <!--전역변수 사용-->
    <input type="text" v-model="msg"/>
</template>

<script>
    export default {
        emits:["myclk", "changeMsg"],
        data(){
            return {msg : ""}
        },
        watch:{
            msg(){
                this.$emit('changeMsg', this.msg)
            }
        }
    }
</script>

<style scoped>
    .btn {
        display : inline-block;
        margin : 4px;
        padding: 6px 12px;
        border-radius: 4px;
        background-color: gray;
        color: white;
        cursor: pointer;
    }
</style>