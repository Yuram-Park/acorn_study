// 비동기
// console.log(1);
// setTimeout(()=>{console.log(2)}, 1000);
// console.log(3);

//************************************************************* */

// 비동기
// const btnEl = document.querySelector("h1");
// btnEl.addEventListener("click", ()=>{
//     console.log("Clicked!");
// });

// console.log("Hello World");

// ***********************************************************

// fetch('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
//     .then(res => res.json())
//     .then(res =>{
//         console.log(res)
//         console.log(1);
//         console.log(2);
//         console.log(3);
//     })

// 인터넷 속도에 따라 얘먼저 실행됨
// console.log(1);
// console.log(2);
// console.log(3);

//*************************************************** */


// const getMovies = (movieName, cb) => {
//     fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
//         .then(res => res.json())
//         .then(res =>{
//             console.log(res);
//             cb();
//         })
// }

// getMovies('frozen', ()=>{
//     console.log("겨울 왕국");
//     getMovies('avengers', ()=>{
//         console.log("어벤져스");
//         getMovies('avatar', ()=>{console.log("아바타");});
//     });
// });


// **************************************************
/*
const getMovies = (movieName) => {
    return new Promise((resolve)=>{
        fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        .then(res => res.json())
        .then(res =>{
            console.log(res);
            resolve();
        })
    })
    
}
*/
/*
getMovies('frozen').then(()=>{
    console.log('겨울왕국');
    return getMovies('avengers')
}).then(()=>{
    console.log('어벤져스')
    return getMovies('avatar')
}).then(()=>{
    console.log('아바타')
});
*/
/*
const func = async() => {
    await getMovies('frozen')
    console.log('겨울왕국');

    await getMovies('avengers')
    console.log('어벤져스');

    await getMovies('avatar')
    console.log('아바타');
}
func();
*/

//****************************************** */
/*
const getMovies = (movieName) => {
    return new Promise((resolve, reject)=>{
        fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        .then(res => res.json())
        .then(json =>{
            //console.log(json);
            if(json.Response == "False"){
                reject(json.Error)
            }
            resolve(json);
        })
        .catch(err => {reject(err)})
    })
}
*/
/*
let loading = true;
getMovies("avengersaaa")
    .then(movies => console.log("영화 목록 : " , movies))
    .catch(error => {
        console.log("에러 발생: ", error);
        loading = false;
    })
*/
/*
const func = async() => {
    try{
    const movies = await getMovies('avengers')
    console.log("영화 목록: ", movies)
    } catch(err){
        console.log(err)
    }
}

func();
*/

//********************** 반복문에서 비동기 처리 ******************** */

const getMovies = (movieName) => {
    return new Promise((resolve)=>{
        fetch(`https://www.omdbapi.com/?apikey=7035c60c&s=${movieName}`)
        .then(res => res.json())
        .then(res =>{resolve();})
    })
}

const titles = ['frozen', 'avengers', 'avatar']
/*
titles.forEach(async title => {
    const movies = getMovies(title)
    console.log(title, movies)
})
*/

const wrap = async()=>{
    for(const title of titles){
        const movies = await getMovies(title)
        console.log(wiwle, movies)
    }
}
wrap();