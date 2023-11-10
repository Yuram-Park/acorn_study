<template>
    <div>
        <h1>컴퍼넌트를 이용한 메모장</h1>
    </div>
    <hr>
    <div id="app">
        <list-page :list="list"></list-page>
    </div>
</template>

<script>
import ListPage from "./pages/ListPage.vue"
    export default {
        components:{
            ListPage
        },
        data(){
            return{list:["김", "이", "박"]}
        }
    }
</script>

<style scoped>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>