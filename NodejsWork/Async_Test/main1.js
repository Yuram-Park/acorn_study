// 콜백과 콜백 지옥
/*
const a = (callback) => {
    setTimeout(()=>{
        console.log(1);
        callback();
    },1000);
}
const b = (callback) => {
    setTimeout(()=>{console.log(2); callback();}, 1000);
};

const c = (callback) => {setTimeout(()=>{console.log(3); callback();}, 1000)}
const d = () => {console.log(4);}


// a();
// b();

a(()=>{b(()=>{c(()=>{d();});})});
*/

//*****************Promise******************* */
/*
const a = () => {
    return new Promise((resolve)=>{
        setTimeout(()=>{
            console.log(1);
            resolve();
        }, 1000)
    })
}

const b = () => {
    return new Promise((resolve)=>{
        setTimeout(()=>{
            console.log(2);
            resolve();
        }, 1000)
    })
}

const c = () => {
    return new Promise((resolve)=>{
        setTimeout(()=>{
            console.log(3);
            resolve();
        }, 1000)
    })
}

const d = () => {console.log(4);}
*/
/*
a().then(()=>{
    b().then(()=>{
        c().then(()=>{
            d()
        })
    })
})
*/

/*
a().then(()=>{
    return b()
}).then(()=>{
    return c()
}).then(()=>{
    return d()
})
*/

/*
a()
    .then(()=>b())
    .then(()=>c())
    .then(()=>d())
    */
/*
a()
    .then(b)
    .then(c)
    .then(d)

*/

//******************** Async, Await 패턴 ************* */
/*
const a = () => {
    return new Promise((resolve)=>{
        setTimeout(()=>{
            console.log(1);
            resolve();
        }, 1000)
    })
};

const b = () => console.log(2);

//a().then(()=>b())

const func = async()=>{
    await a();
    b();
}
func()
*/

//******************* Resolve, Reject, error handling ******************* */

// const delayAdd = (num, cb, errcb) => {
//     setTimeout(()=>{
//         if(num > 10){
//             errcb(`${num}은 10보다 클 수 없다.`)
//             return
//         }
//         console.log(num);
//         cb(num + 1);
//     }, 1000)
// };

// delayAdd(40, (res)=>{console.log(res)}, (err)=>{console.log(err)});


const delayAdd = (num) => {
    return new Promise ((resolve, reject)=>{
        setTimeout(()=>{
            if(num > 10){
                reject(`${num}은 10보다 클 수 없다.`)
                return
            }
            console.log(num);
            resolve(num + 1);
        }, 1000)
    })
};

//delayAdd(11).then((res)=>{console.log(res)},(err)=>{console.log(err)});
//delayAdd(11).then((res)=>{console.log(res)}).catch((err)=>{console.log(err)});

const func = async() => {
    try{
        const res = await delayAdd(11);
        console.log(res);
    } catch(err){
        console.error(err)
    } finally {
        console.log("Done.")
    }
};

func();