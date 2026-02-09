

window.addEventListener('load', () => {
    const btn4 = document.querySelector('#btn4')
    btn4.addEventListener('click', btn4click)
    // btn4.removeEventListener('click',btn4click)
    

    const game = document.querySelector('#game')
    document.querySelector('body').addEventListener('keydown', function (event) {
        console.log('body event.keycode : ', event.keycode)

        const game = document.querySelector('#game')
        console.log('game.style.left:', game.style.left)
        if (event.keycode == 39) {
            game.style.letf = (parseInt(game.style.left) + 10) + 'px'
        } else if (event.keycode == 37) {
            game.style.left = (parseInt(game.style.left) - 10) + 'px'
        }
    })

    document.querySelector('#top').addEventListener('click', () => {
        console.log(document.documentElement.scrollTop)
        // document.documentElement.scrollTop = 0
        window.scrollTo({
            top: 0,
            behavior:'smooth'
        })

        // // 계산 결과가 실시간으로 반영되지 않음       
        // let top = document.documentElement.scrollTop
        // while(top > 0){
        //     document.documentElement.scrollTop -= 10
        //     top = document.documentElement.scrollTop           
        // }

        // 시간에 따라 setTimeout 많이 만들어두고 부드럽게 움직이게 하려고 함
        // for(let i = document.documentElement.scrollTop; i >=0; i--){
        //     let delay = 2000 -i
        //     setTimeout(() => {
        //         document.documentElement.scrollTop = i
        //     }, delay)
        // }
    })


})


function btn4click() {
    const console1 = document.querySelector('#console')
    console1.innerHTML += '<br>버튼4 클릭'
    
}



