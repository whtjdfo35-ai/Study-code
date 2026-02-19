window.addEventListener('load', () => {
    const log = document.querySelector('#log')

    window.addEventListener('resize', () => {
        const w = window.innerWidth;
        const h = window.innerHeight;

        log.innerHTML += `<br>너비: ${w}, 높이: ${h}`
    })

    const id = document.querySelector('#id')
    id.addEventListener('focus', () =>
        id.style.backgroundColor = 'yellow'
    )
    id.addEventListener('blur', () =>
        id.style.backgroundColor = 'white'
    )

    id.addEventListener('input', () => {
        const r = parseInt(Math.random() * 256)
        const g = parseInt(Math.random() * 256)
        const b = parseInt(Math.random() * 256)
        const a = Math.random()

        id.style.backgroundColor = `rgba(${r},${g},${b},${a})`

    })

    const site = document.querySelector('#site')
    const form = document.querySelector('#form')
    site.addEventListener('change', () => {
        if (site.value == 2) {
            form.setAttribute('action', "https://www.google.co.kr/search")
        }
    })

    form.addEventListener('submit', event => {

        //html의 기본 기능을 정지
        event.preventDefault()

        if (id.value.length < 2) {
            alert('검색어는 두 글자 이상입니다')
        } else {
            form.submit()
        }
    })


    addEventListener('copy', event => {
        event.preventDefault()
        this.alert('복사금지')
    })

    //우클릭 메뉴를 안 뜨게 한다
    addEventListener('selectstrart', event => {
        event.preventDefault()
    })

    document.querySelector('#parent').addEventListener('click', event => {
        console.log('부모클릭')
        console.log(event.target)
        console.log('event.currentTarget', event.currentTarget)

        console.log('this', this)
        console.log('this', this === event.currentTarget)
        //화살표 함수일때는 this변경x
        //funtion(event)로 적으면 this === event.currentTarget true
        // ,true //캡쳐링 단계에서 실행으로 변경
    })

    document.querySelector('#child1').addEventListener('click', event => {
        // event.stopPropagation()
        console.log('자식1클릭')
    })

    //table태그 이벤트
    // document.querySelector('#board').addEventListener('click', event =>{
    //     console.log(event.target)

    //     if(event.target.classList.contains('chk')){
    //         console.log(event.target.value)
    //     } else if (event.target.classList.contains('title')){
    //         console.log(event.target.textContent)
    //     }
    // })

    let tr = document.querySelectorAll('#board tr')
    for (let i = 0; i < tr.length; i++) {
        tr[i].addEventListener('click', event => {
            // if (!(event.target.classList.contains('chk'))){
            console.log(tr[i].querySelector('.title').innerText)
            // }
        })

        tr[i].querySelector('.chk').addEventListener('click', event => {
            event.stopPropagation()

            // this.parentNode
            //부모로 이동
            //arrow함수라 this 못 써서 event.target씀

            console.log(event.target.parentNode.parentNode.querySelector('.title').textContent)
        })
    }

    
})

console.log('밖에서 this:', this)
console.log('밖에서 window:', this === window)