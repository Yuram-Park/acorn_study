<template>
    <header-component title="리스트 페이지"></header-component> <!--title이라는 이름으로 ""내용을 자식에게 전달하겠다-->
    <div>
        리스트 컨텐츠
        <ul>
            <li v-for="(memo, index) in list" :key="index" @click="setReadMemo(index)">{{index}}, {{memo}}</li>
        </ul>
    </div>
    <footer-component></footer-component>
</template>

<script>
import HeaderComponent from "../../components/HeaderComponent.vue"
import FooterComponent from "../../components/FooterComponent.vue"

    export default {
        components:{
            HeaderComponent,
            FooterComponent
        },
        props:{
            list:{
                type: Array,
                default:[]
            },
            // list를 App에서 가져오므로 read로 보낼때도 props에서 해줘야한다
            setReadMemo: {
                type: Function
            }
        }
    }
</script>

<style scoped>

</style>