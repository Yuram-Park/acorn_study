<template>
    <div class="sample" @click="addCount">
        {{ count }}
    </div>
</template>

<script>
    export default {
        emits:["changeSample"],
        data(){
            return{
                count: 1
            }
        },
        methods:{
            addCount(){
                this.count++;
                this.$emit("changeSample", this.count);
            }
        }
    }
</script>

<style scoped>
    .sample{
        border: 1px solid black;
        margin: 10px;
    }
</style>