<template>
    <header-component title="읽기 페이지"></header-component> <!--title이라는 이름으로 ""내용을 자식에게 전달하겠다-->
    <div>
        <ul>
            <p>선택된 메모 = {{ CurrentMemo }}</p>
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
            CurrentMemo :{
                type : String,
                default : ""
            }
        }
    }
</script>

<style scoped>

</style>