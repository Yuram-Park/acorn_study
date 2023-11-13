<template>
    <!-- <h1 ref="hello">Hello World</h1> -->
    <hello ref="hello"></hello>
</template>

<script>
    import Hello from './components/Hello.vue'
    export default {
        components:{
            Hello
        },
        mounted(){
            //const h1El = document.querySelector('#hello');
            //console.log(this.$refs.hello.textContent);
            //console.log(this.$refs.hello);
            //----------컴포넌트 참조
            //console.log(this.$refs.hello.$el) // element 접근
            console.log(this.$refs.hello.$refs.good)
        }
    }
</script>

<style scoped>
    
</style>