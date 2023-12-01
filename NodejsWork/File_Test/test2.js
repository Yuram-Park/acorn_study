const fs = require("fs");

fs.readFile("./stdin.txt", "utf-8", function(err, data){
    if(err) throw err;
    const nums = data.toString().split("\n");

    const multiplication = nums[0] * nums[1] * nums[2];
    
    const compare = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    const number = multiplication.toString().split("");
    let result = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for (i in number){
        for(j in compare){
            if(number[i] == compare[j])
            result[j]++
        }
    }

    console.log(result.join(" "));
    
})

