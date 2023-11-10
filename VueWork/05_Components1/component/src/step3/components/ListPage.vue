<template>
    <div class="test1">
        <list-header></list-header>
      <div>
        <ul>
            <li v-for="memo in list" :key="memo">{{ memo }}</li>
        </ul>
      </div>
      <list-footer></list-footer>
        </div>
</template>

<script>
import ListHeader from "./ListHeader"
import ListFooter from "./ListFooter"
export default {
    components: {
        ListHeader,
        ListFooter
    },
    data(){
        //return { list : ["memo1", "memo2", "memo3"]}
    },
    props : {
        list : {
            type: Array, // 전달 받는 타입
            required: true // 반드시 받을 것인지?
        }
    }
}
</script>

<style>
    .test1 {font-size: 20px;}
</style>