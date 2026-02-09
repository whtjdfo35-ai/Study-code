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
    id.addEventListener('blur',() =>
        id.style.backgroundColor = 'white'
    )

    id.addEventListener('input', () =>{
        const r = parseInt(Math.random()*256)
        const g = parseInt(Math.random()*256)
        const b = parseInt(Math.random()*256)
        const a = Math.random()

        id.style.backgroundColor = `rgba(${r},${g},${b},${a})`
        
    })

    const site = document.querySelector('#site')
    const form = document.querySelector('#form')
    site.addEventListener('change', () => {
        if(site.value ==2){
            form.setAttribute('action', "https://www.google.co.kr/search")
        }
    })

    form.addEventListener('submit', event =>{
        
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
})