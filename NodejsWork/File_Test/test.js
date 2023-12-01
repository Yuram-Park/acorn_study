const fs = require("fs");

fs.readFile("./customer.txt", "utf-8", function(err, data){
    if(err) throw err;
    const arr = data.toString().split("\n");
    
    for (i in arr){
        let name = arr[i].toString().split(" ");
        console.log(`${i}번째 줄에서 이름은 ${name[0]}이다.`)
    }
})