<template>
    <header-component title="리스트 페이지"></header-component> <!--title이라는 이름으로 ""내용을 자식에게 전달하겠다-->
    <div>
        리스트 컨텐츠
        <ul>
            <li v-for="(data, index) in list" :key="index">{{index}}, {{data}}</li>
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
            }
        }
    }
</script>

<style scoped>

</style>