window.onload = () => {
    bind()
}

function bind() {
    const log = document.querySelector('#log')

    const area = document.querySelector('#area')
    area.oncontextmenu = () => false
    //선택 영역에서 우클릭 기능 막음

    // area.addEventListener('contextmenu',() => false)
    // 지금은 안됨

    area.onselectstart = () => false
    //선택한 영역내에서 드래그를 막음

    area.addEventListener('dblclick', () => {
        let div = document.createElement('div')
        div.innerHTML = '더블클릭 발생'
        log.prepend(div)
    })

    area.addEventListener('mousedown', () => {
        let div = document.createElement('div')
        div.innerHTML = 'mousedown 발생'
        log.prepend(div)
    })

    area.addEventListener('mouseup', () => {
        let div = document.createElement('div')
        div.innerHTML = 'mouseup 발생'
        log.prepend(div)
    })

    area.addEventListener('click', evt => {
        console.log('evt.offsetY:', evt.offsetY) //dom의 좌상단 기준
        console.log('pageY:',evt.pageY)          // page 좌상단 기준   
        console.log('clientY:',evt.clientY)      // 지금 보이는 브라우저 좌상단 기준   
        console.log('screenY:',evt.screenY)      // 모니터 화면 좌상단 기준   
        showLog('click 발생')
    })

    // 커서를 올렸을때 동작
    // area.addEventListener('mouseenter', () => {
    area.addEventListener('mouseover', () => {
        showLog('mouseover 발생')
        area.style.backgroundColor = 'yellow'
    })

    // 커서가 떠났을때
    // area.addEventListener('mouseleave', () => {
    area.addEventListener('mouseout', () => {
        showLog('mouseout 발생')
        area.style.backgroundColor = 'white'
    })

  
    let mousePositionX = document.offsetX
    let mousePositionY = document.offsetY
    document.addEventListener('mousedown', evt => {        
        mousePositionX = evt.offsetX
        mousePositionY = evt.offsetY
    })
    document.addEventListener('mouseup', evt => {
        let mousePositionX2 = evt.offsetX
        let mousePositionY2 = evt.offsetY
        if (mousePositionX == mousePositionX2 && mousePositionY == mousePositionY2) {           
            showLog('click')                                  
        }
    })

    // area.addEventListener('mousemove', evt => {
    //     const offsetX = evt.offsetX
    //     const offsetY = evt.offsetY
    //     showLog(`offsetX: ${offsetX}, offsetY : ${offsetY}`)
    //     showLog('mousemove 발생')       
    // })

    document.querySelector('body').addEventListener('mousemove', evt =>{
        const cursor = document.querySelector('#cursor')
        const pageX = evt.pageX
        const pageY = evt.pageY
        
        cursor.style.left = pageX+10+'px'
        cursor.style.top = pageY+'px'              
    })

    

    document.querySelector('body')
        .addEventListener('mousemove', evt => {
            if(isDrag){
                let drag = document.querySelector('#drag')
                const pageX = evt.pageX
                const pageY = evt.pageY
                drag.style.left = pageX-dragOffsetX+'px'
                drag.style.top = pageY-dragOffsetY+'px'
            }
    })
    
    document.querySelector('#drag')
        .addEventListener('mousedown', evt => {
            isDrag = true
            dragOffsetX = evt.offsetX
            dragOffsetY = evt.offsetY
    })
    document.querySelector('#drag')
        .addEventListener('mouseup', evt =>         
            isDrag = false
    )

}
// let isDrag = false
let dragOffsetX = 0
let dragOffsetY = 0


function showLog(msg) {
    let div = document.createElement('div')
    div.innerHTML = msg
    log.prepend(div)
}