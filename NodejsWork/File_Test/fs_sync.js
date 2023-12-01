const fs = require("fs")
const content = "Hello World!!";

try{
fs.writeFileSync("./hell.txt", content);
} catch(err){
    console.log(err)
}

try{
const data = fs.readFileSync("./hello.txt", "utf-8");
console.log(data);
} catch(err) {
    console.log(err);
}