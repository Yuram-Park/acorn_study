<template>
  <!--
  <MyBtn class="mycss" style="color:red"> 클래스가 상속되어 btn mycss됨
    MyButton
  </MyBtn>
  -->
  <!--<MyBtn/> // slot 값 나옴 -->
  <MyBtn>
    <template v-slot:icon>
      <span>(A)</span>
    </template>
    <template #text>
      <span>MyButton</span>
    </template>



  </MyBtn>
</template>

<script>
import MyBtn from './components/MyBtn.vue'


export default {
  components:{
    MyBtn
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
