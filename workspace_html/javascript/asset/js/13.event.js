console.log('hello js')

// id btn1을 변수 btn1에 담아서 console.log로 출력
const btn1 = document.querySelector('#btn1')
console.log(1, 'btn1', btn1)

// window.onload = init;
window.addEventListener('load', init)

function init() {
    const btn1 = document.querySelector('#btn1')
    console.log(2, 'btn1', btn1)

    const game = document.querySelector('#game')
    game.style.left = '10px'
    game.style.top = '300px'

    bind()
}

function btn3click() {
    const console = document.querySelector('#console')
    console.innerHTML += '<br>버튼3 클릭'
}

function bind() {

    const log = document.querySelector('#console')

    const btn1 = document.querySelector('#btn1')
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 클릭'
    }
    // onclick은 변수라서 하나의 값만 저장된다
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 click'
    }

    const btn2 = document.querySelector('#btn2')
    // addEventListener : 동일한 이벤트에 여러 함수를 추가할 수 있다
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 click'
    })
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 클릭'
    })

    // 로그인 버튼을 눌렀을 때
    // 아이디와 비밀번호가 비어있지 않다면
    //      아이디, 비밀번호 출력
    // 하라나도 비어있다면
    //      아이디는 필수입니다
    //      비밀번호는 필수입니다 출력
    const login = document.querySelector('#login')
    login.addEventListener('click', function () {

        const id = document.querySelector('#id')
        const pw = document.querySelector('#pw')

        if (id.value.trim() != ''
            && pw.value.trim().length != 0) {
            log.innerHTML += '<br>' + id.value + ',' + pw.value
            log.innerHTML += `<br>${id.value}, ${pw.value}`
        } else {
            if (id.value.trim() == '') {
                log.innerHTML += '<br>아이디는 필수입니다'
            }
            if (pw.value.trim() == '') {
                log.innerHTML += '<br>비밀번호는 필수입니다'
            }
        }
    })

    document.querySelector('#id').addEventListener('keydown', function () {
        // log.innerHTML += '<br>keydown 발생'
    })
    document.querySelector('#id').addEventListener('keyup', function (event) {
        log.innerHTML += '<br>keyup 발생'
        console.log(event)
        console.log('event.key', event.key)
        console.log('event.keyCode', event.keyCode)

        console.log('event.shiftKey', event.shiftKey)
        console.log('event.ctrlKey', event.ctrlKey)
        console.log('event.altKey', event.altKey)
        // 엔터를 누르면
        // "엔터 빵!!" 출력하시오
        if (event.keyCode == 13) {   // 엔터
            console.log("엔터 빵!!")
            log.innerHTML += '<br>엔터 빵!!'

            document.querySelector('#pw').focus()   // DOM에 focus 발생
        }
        if (event.ctrlKey == true && event.keyCode == 67) {
            alert('ctrl+c')
        }
    })

    document.querySelector('#pw').addEventListener('keyup', function (event) {
        if (event.keyCode == 13) {   // 엔터
            document.querySelector('#login').click() // DOM에 click 발생
        }
    })

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

    window.addEventListener('scroll', () =>
        console.log('window.scrollY:',scrollY)
    )    
}


function btn4click() {
    const console1 = document.querySelector('#console')
    console1.innerHTML += '<br>버튼4 클릭'
    
}



