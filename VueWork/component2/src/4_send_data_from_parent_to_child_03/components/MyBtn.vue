<template>
    
    <div class="btn">
        <slot name="icon"></slot>
        <slot name="text"></slot>
    </div>
    <!-- <div></div> 2개 이상 되면 상속 안됨-->
    <!--
    <h1 :class="$attrs.class" :style="$attrs.style">test</h1>
    -->
    <!--<h1 v-bind="$attrs">test</h1>-->
</template>

<script>
    export default {
        //inheritAttrs:false, // 자동상속

    created() {
        console.log(this.$attrs)
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