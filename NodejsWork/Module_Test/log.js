const log = {
    info: function(info){
        console.log("info : " + info);
    },

    warning: function(warning){
        console.log("warning : " + warning);
    },

    error: (error) => {
        console.log("error : " + error);
    }
};

module.exports = log; // default


// 상수 export
module.exports.A = 100;

// 함수 export
exports.test1 = function(data){ // module은 생략 가능
    return data;
}