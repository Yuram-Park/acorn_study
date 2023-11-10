<template>
    <div id="app">
        <div>
            <button @click="toggle()">토글-{{ sw }}</button><!--true, false-->
            <button @click="addMessage()">데이터 변경</button>
        </div>
        <!-- message = 1, 2, 3, 4, 5, 6, 7-->
        <div>1. message = {{ message }}</div>
        <div>2. computed = {{ reverseMessage }}</div>
        <div>3. methods = {{ reverseMessage2() }}</div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            message : "1, 2, 3, 4, 5, 6, 7",
            sw : true,
            count : 7
        }
    },
    methods: {
        toggle(){
            this.sw = !this.sw;
        },
        addMessage(){
            this.count++;
            this.message += "," + this.count;
        },
        reverseMessage2(){
            return this.message.split(",").reverse().join("_");
        }
    },
    computed: {
        reverseMessage(){
            return this.message.split(",").reverse().join("_");
        }
    }
}
</script>

<style>

</style>