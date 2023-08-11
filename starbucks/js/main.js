const searchEl = document.querySelector(".search")
const searchInputEl= document.querySelector("input")

searchEl.addEventListener("click", ()=>{
    searchInputEl.focus()
})

searchInputEl.addEventListener("focus", ()=>{
    searchEl.classList.add('focused')
    searchInputEl.setAttribute("placeholder","통합검색")
})
searchInputEl.addEventListener("blur", ()=>{
    searchEl.classList.remove('focused')
    searchInputEl.setAttribute("placeholder","")
})


// Main-menu

const mainMenu = document.querySelector(".main-menu")
const coffee = mainMenu.firstElementChild

// coffee.addEventListener("mouseover", ()=>{
//     coffee.style.backgroundColor = "black"
// })


// BADGES

const badgeEl = document.querySelector("header .badges")

/* lodash cdn 검색*/
// core 버전 -> 원본 그대로 가져오는 것
// min 버전 -> 최적화, 압축시킨 것
// window.addEventListener("scroll", _.throttle(()=>{
//     if(window.scrollY > 500 ) {
//         badgeEl.style.display='none';
//     } else {
//         badgeEl.style.display='block';
//     }
// }, 300))


/* gsap cdn 검색 */
window.addEventListener("scroll", _.throttle(()=>{
    if(window.scrollY > 500 ) {
        //gsap.to(요소, 지속시간, 옵션)
        gsap.to(badgeEl, .6, {opacity:0, display:'none'})
    } else {
        gsap.to(badgeEl, .6, {opacity:1, display:'block'})
    }
}, 300))

/* Visual Image를 순차적으로 나타나게 하는 기능 */
const fadeEls = document.querySelectorAll(".visual .fade-in")

fadeEls.forEach((el, cnt)=>{
    gsap.to(el, 1, {opacity:1, delay:(cnt+1)*.7})
})

/* 슬라이드 요소 관리*/
new Swiper(".notice-line .swiper-container", {
    direction: 'vertical',
    loop: true,
    autoplay: true
})


new Swiper(".promotion .swiper-container", {
    direction: 'horizontal',
    slidesPerView: 3,
    spaceBetween: 10,
    centeredSlides: true,
    loop: true,
    autoplay: {delay:5000},
    pagination: {
        el: '.swiper-pagination',
        clickable: true
    },
    
      // Navigation arrows
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'}

})

/* Promotion 토글 */
const promotionEl = document.querySelector(".promotion")
const promotionToggleBtn = document.querySelector(".toggle-promotion")
let isHidePromotion = false;

promotionToggleBtn.addEventListener("click", ()=>{
    if(isHidePromotion) {
        promotionEl.classList.remove("hide")
        isHidePromotion= false;
    } else {
        promotionEl.classList.add("hide")
        isHidePromotion= true;
    }
})

/* 떠다니는(부유하는) 요소를 만드는 함수*/
function rand(min, max) {
    return parseFloat((Math.random()*(max-min)+min).toFixed(2))}

function floatingObject(selector, delay, size) {
    gsap.to(selector, rand(1.5,2.5), {
        y: size,
        repeat: -1,
        yoyo: true,
        delay: rand(0, delay),
        ease: Power1.easeInOut,
        
    })
}
floatingObject('.floating1', 1, 15)
floatingObject('.floating2', .5, 15)
floatingObject('.floating3', 1.5, 20)



// Season Product fade-in

// function fadeSeason(selector, delay, size, opacity) {
//     gsap.to(selector, delay, {
//         x: size,
//         delay: delay,
//         opacity: opacity
//     })
// }
   

// let innerText = document.querySelector(".innerText")
// let fadePrd = document.querySelector(".season-fade.Prd")
// let fadeText1 = document.querySelector(".season-fade.Text1")
// let fadeText2 = document.querySelector(".season-fade.Text2")
// let fadeBtn = document.querySelector(".btn.season-fade")

// document.addEventListener('scroll', ()=>{
//     if (window.scrollY > 1500) {
//         fadeSeason(fadePrd, .7, 50, 1)
//         fadeSeason(fadeText1, .7, -50, 1)
//         setTimeout(fadeSeason(fadeText2, .7, -50, 1), 1000)
//         setTimeout(fadeSeason(fadeBtn, .7, -50, 1), 3000)

//     } else {
//         fadeSeason(fadePrd, .7, -50, 0)
//         fadeSeason(fadeText1, .7, 50, 0)
//         fadeSeason(fadeText2, .7, 50, 0)
//         fadeSeason(fadeBtn, .7, 50, 0)
//     }
// })



