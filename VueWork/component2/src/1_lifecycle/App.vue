<template>
  <h1>컴퍼넌트 라이프 사이클 테스트</h1>
  <div>
    <button @click="sw=true">컴퍼넌트 mount</button>
    <button @click="sw=false">컴퍼넌트 unmount</button>
  </div>
  <parent-component v-if="sw"></parent-component>
</template>

<script>
  import ParentComponent from "./components/ParentsComponent.vue"
export default {
  name: 'App',
  components: {
    ParentComponent
  },
  data(){
    return {sw : true}
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
