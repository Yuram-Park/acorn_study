<template>
    <header-component title="읽기 페이지"></header-component> <!--title이라는 이름으로 ""내용을 자식에게 전달하겠다-->
    <div>
        <ul>
            <p>선택된 메모 = {{ CurrentMemo }}</p>
        </ul>
    </div>
    <div>
        <button @click="setMode(MODE.LIST)">리스트 페이지로 이동</button>
    </div>
    <br>
    <footer-component></footer-component>
</template>

<script>
import HeaderComponent from "../../components/HeaderComponent.vue"
import FooterComponent from "../../components/FooterComponent.vue"
import {MODE} from "../common.js"

    export default {
        components:{
            HeaderComponent,
            FooterComponent
        },
        props:{
            CurrentMemo :{
                type : String,
                default : ""
            },
            setMode:{
                type: Function,
                default: ()=>{
                    console.log("이 함수는 재설정을 해야 합니다.")
                }
            }
        },
        computed :{
            MODE(){
                return MODE;
            }
        }
    }
</script>

<style scoped>

</style>