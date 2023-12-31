/*
모듈
------
- npm i express
- npm i morgan

*/

const morgan = require('morgan');
const express = require('express');

const app = express();
app.set('port', process.env.PORT || 9999);

app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({extended:true}))

let boardList = [];
let board_id = 0;
app.get("/", (req, res)=>{
    res.send("<h1>게시판 연습</h1>")
})

app.get("/board", (req, res)=>{
    res.send(boardList);
})

app.post("/board", (req, res)=>{
    const board = {
        "id" : ++board_id,
        "user_id" : req.body.user_id,
        "date" : new Date(),
        "title" : req.body.title,
        "content" : req.body.content
    }
    boardList.push(board);

    res.redirect('/board');
})


app.delete("/board/:id", (req, res)=>{
    const findItem = boardList.find((item) => {
        return item.id === +req.params.id // + -> 이 값을 loggin 하겠다
    });

    const idx = boardList.indexOf(findItem);
    boardList.splice(idx, 1);

    res.redirect("/board");
})

app.put("/board/:id", (req, res)=>{
    const findItem = boardList.find((item)=>{ return item.id == +req.params.id})
    const idx = boardList.indexOf(findItem);
    boardList.splice(idx, 1);

    const board = {
        "id" : req.params.id,
        "user_id" : req.body.user_id,
        "date" : new Date(),
        "title" : req.body.title,
        "content" : req.body.content
    }
    boardList.push(board);
    res.redirect("/board");
})

app.listen(app.get('port'), ()=>{

})