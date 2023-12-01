const express = require("express");
const usersRouter = require("./routes/users.routes");
const postsRouter = require("./routes/posts.routes");
const path = require("path");

// constants
const PORT = 4000;
const HOST = "0.0.0.0";

// 객체(서버) 생성
const app = express();

// MiddleWare
app.set("view engine", "hbs"); // set -> 전역변수로 설정
app.set("views", path.join(__dirname, 'views'));
app.use((req, res, next)=>{ // use -> 지역변수로 설정
    const start = Date.now();
    console.log(`start : ${req.method} ${req.url}`);
    next();

    const diffTime = Date.now() - start; // middleware에서 걸리는 시간
    console.log(`end : ${req.method} ${req.url} ${diffTime}`);
})

app.use(express.json());

app.use("/static", express.static(path.join(__dirname, 'public')));
// http://localhost:4000/static/index.html

app.use("/users", usersRouter);
app.use("/posts", postsRouter);

app.get("/", (req, res)=>{
    //res.send("<h1>Hello World~~</h1>");
    res.render('index', {
        imageTitle : "This is a Forest ...",
        title: "Main Page"
    })
})


app.listen(PORT, HOST);
console.log(`Running on http://${HOST}:${PORT}`);
