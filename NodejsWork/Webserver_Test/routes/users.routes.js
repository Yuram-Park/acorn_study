const express = require("express");
const userControllers = require("../controllers/users.controller");

const usersRouter = express.Router();

// usersRouter.get("/", (req, res) =>{
//     res.send("<h1>Hello World~</h1>");
// });

usersRouter.get("/", userControllers.getUsers);

usersRouter.get("/:userId", userControllers.getUser);

usersRouter.post("/", userControllers.postUser);

module.exports = usersRouter;
