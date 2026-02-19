window.addEventListener('load', () => {
    //q1
    document.querySelector('#login').addEventListener('click', event => {
        if (!document.querySelector('#id2').value) {
            document.querySelector('.alr').innerText = '아이디를 입력해주세요'
            document.querySelector('.alr').style.color = 'red'
        } else if (!document.querySelector('#pw2').value) {
            document.querySelector('.alr').innerText = '비밀번호를 입력해주세요'
            document.querySelector('.alr').style.color = 'red'
        }
    })
    document.querySelector('#pw2').addEventListener('input', event => {
        if (document.querySelector('#id2').value
            && document.querySelector('#pw2').value) {
            document.querySelector('.alr').innerText = ''
        }
    })


    //q2
    document.querySelector('#cfm').addEventListener('click', event => {

        let topsum = 0
        let order = document.querySelector('.order')

        order.textContent = '선택내역: ' + document.querySelector('.typ:checked').value
        order.textContent += ',' + document.querySelector('.size:checked').parentNode.textContent
        order.textContent += ',' + document.querySelector('.edge:checked').parentNode.textContent

        for (let i of document.querySelectorAll('.top:checked')) {
            topsum += parseInt(i.value)
            order.textContent += ',' + i.parentNode.textContent
        }
        let price = topsum + parseInt(document.querySelector('.size:checked').value)
        document.querySelector('.price').innerText = '총액: ' + price + '원'

        console.log(document.querySelector('.typ:checked').value)

    })


    //q3
    document.querySelector('.ca').addEventListener('change', event => {
        if (document.querySelector('.ca').checked) {
            document.querySelector('.name2').value = document.querySelector('.name').value
            document.querySelector('.adr2').value = document.querySelector('.adr').value
        } else {
            document.querySelector('.name2').value = ''
            document.querySelector('.adr2').value = ''
        }
    })


    //q4
    document.querySelector('#menu').addEventListener('click', event => {
        const li = event.target.parentNode.querySelectorAll('li')
        if (event.target.style.fontWeight == 400) {
            for (let i = 0; i < li.length; i++) {
                li[i].style.fontWeight = 400
            }
            event.target.style.fontWeight = 'bold'
        } else if (event.target.style.fontWeight == 'bold') {
            for (let i = 0; i < li.length; i++) {
                li[i].style.fontWeight = 400
            }
        }
    })


    //q5
    document.querySelector('#tn').addEventListener('mouseover', event => {
        document.querySelector('#bi').style.left = 0 + 'px'
    })
    document.querySelector('#tn').addEventListener('mouseout', event => {
        document.querySelector('#bi').style.left = -5000 + 'px'
    })


    //q6
    // 추가 버튼을 누를때 이벤트
    document.querySelector('.subm').addEventListener('click', event => {
        //할 일 목록 생성
        let div = document.createElement('div')
        // let label = document.createElement('label')
        let label = document.createElement('span')
        let chkb = document.createElement('input')
        let del = document.createElement('button')

        label.append(chkb)
        div.append(label, del)        
        document.querySelector('.list').append(div)

        chkb.setAttribute('type', 'checkbox')
        chkb.setAttribute('class', 'chkb')
        chkb.setAttribute('name', '할일')
        label.innerHTML += document.querySelector('.todo').value
        del.innerText = '삭제'
        document.querySelector('.todo').value = ''
    })

    //리스트를 클릭할때 발생하는 이벤트
    document.querySelector('.list').addEventListener('click', event => {
        if (event.target.innerText == '삭제') {
            event.target.parentNode.remove()
        }
        let i =0
        for(let ob of document.querySelectorAll('.chkb')){                  
            if(ob.checked){
                i++
                ob.parentNode.style.textDecoration= 'line-through'
            } else {
                ob.parentNode.style.textDecoration= ''
            }
        }
        if(i == document.querySelectorAll('.chkb').length){
            document.querySelector('.cha').checked = true
        } else {
            document.querySelector('.cha').checked = false
        }
    
    })

    document.querySelector('.cha').addEventListener('click', event => {
        if (document.querySelector('.cha').checked) {
            for (let i of document.querySelectorAll('.chkb')) {
                // i.setAttribute('checked','checked')
                i.checked = true
            }
        } else {
            for (let i of document.querySelectorAll('.chkb')) {
                // i.removeAttribute('checked')
                i.checked = false
            }
        }
    })
    
    document.querySelector('.chdel').addEventListener('click', event => {
        for (let ob of document.querySelectorAll('.chkb')) {
            if (ob.checked) {
                ob.parentNode.parentNode.remove()
            }
        }       
    })
})
