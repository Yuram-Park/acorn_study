const path = require("path");

function getPost(req, res) {
    //res.sendFile(path.join(__dirname, '..', 'public', 'images', 'a.jpg'));
    res.render('posts', {
            tempName : "post",
            title: "Post Page"
        })

}

module.exports = {getPost}