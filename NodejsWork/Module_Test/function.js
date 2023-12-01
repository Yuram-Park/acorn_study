// CommonJS module

function HelloWorld(){ // 함수 앞에 직접 exports는 불가능. 변수로 지정 후에는 직접 exports 가능
    console.log("Hello world ~")
};

// module.exports = {HelloWorld: HelloWorld}

export default {HelloWorld};