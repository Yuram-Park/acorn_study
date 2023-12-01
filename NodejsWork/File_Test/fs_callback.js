const fs = require("fs")
const content = "Hello World!!";

fs.writeFile("./hello.txt", content, (err)=>{
    if(err){
        console.log(err);
    }

    fs.readFile("./hello.txt", "utf-8", (err, data)=>{
        if(err){
            console.log(err);
        }
        console.log(data);
    });
});