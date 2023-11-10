<template>
    <header-component title="리스트 페이지"></header-component> <!--title이라는 이름으로 ""내용을 자식에게 전달하겠다-->
    <div>
        리스트 컨텐츠
        <ul>
            <li>memo1</li>
            <li>memo2</li>
            <li>memo3</li>
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
        }
    }
</script>

<style scoped>

</style>