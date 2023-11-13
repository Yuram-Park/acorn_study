<template>
  <h1>참조하기</h1>
  <div>
    <button @click="getCount1">1번째 count값 알아내기</button>
    <button @click="getCount2">2번째 count값 알아내기</button>
    <button @click="getInput1">input1 포커스 이동</button>
  </div>

  <div>
    <sample-component @changeSample="getValue"></sample-component>
    <sample-component @changeSample="getValue"></sample-component>
  </div>
  <div>
    <parent-component ref="parent"></parent-component>
  </div>
</template>

<script>
  import ParentComponent from "./components/ParentsComponent.vue"
import SampleComponent from './components/SampleComponent.vue'
export default {
  name: 'App',
  components: {
    ParentComponent,
    SampleComponent
  },
  data(){
    return { message:"", count:0}
  },
  methods:{
    getValue(value){
      this.count = value;
    },
    getCount1(){
      //첫번째 샘플컴퍼넌트의 count 값 출력
      console.log("Sample1 : " + this.count);
    },
    getCount2(){
      //두번째 샘플컴퍼넌트의 count값 출력
      console.log("Sample2 : " + this.count)
    },
    getInput1(){
      // Child컴퍼넌트의 text에 focus 주기
      this.$refs.parent.$refs.child.$refs.target.focus();
    }
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
