window.addEventListener('load', () => {
    bind()
})

function bind() {
    const btn1 = document.querySelector('#btn1')
    btn1.addEventListener('click', () => {
        //ajax 객체 생성
        const xhr = new XMLHttpRequest();

        //보낼준비
        xhr.open('get', 'https://jsonplaceholder.typicode.com/users')

        //보내기
        xhr.send()
        console.log(0, xhr.responseText)

        //request요청 response응답
        //onload 요청해서 응답을 받으면
        xhr.onload = () => {
            console.log('다녀왔어')
            console.log(xhr.responseText)

            const xh1 = JSON.parse(xh1.responseText)
            console.log("두번째 사람의 이름:", xh1[1].name)
            console.log("세번째 사람의 lat:", xh1[2].address.geo.lat)
        }

    })
    const btn2 = document.querySelector('#btn2')
    btn2.addEventListener('click', () => {
        const xhr2 = new XMLHttpRequest();

        xhr2.open('get', 'http://127.0.0.1:5500/workspace_html/javascript/17_json.html')

        xhr2.send()
        console.log(0, xhr2.responseText)

        xhr2.onload = () => {
            console.log(xhr2.responseText)
        }
    })
    const btn3 = document.querySelector('#btn3')
    btn3.addEventListener('click', () => {
        const xhr = new XMLHttpRequest();
        const key = '7d53f8db279583f70e06b5cdb164797a72f97281cc02b8470c421abdefd097e7'
        let url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst'
        url += '?serviceKey=' + key
        url += '&numOfRows=1000'
        url += '&pageNo=1'
        url += '&dataType=JSON'
        url += '&base_date=20260212'
        url += '&base_time=1300'
        url += '&nx=63'
        url += '&ny=110'

        xhr.open('get', url)

        xhr.send()

        xhr.onload = () => {
            const data = JSON.parse(xhr.responseText)
            console.log(data)
            console.log(data.response.body.items.item[0].category)
            console.log(data.response.body.items.item[0].fcstValue)

            let json = {}

            for (let ob of data.response.body.items.item) {
                if (ob.category == 'T1H' || ob.category == 'RN1' || ob.category == 'REH') {
                    console.log(ob)
                    document.querySelector('.tb').innerHTML +=
                        `<tr>
                            <td>${ob.fcstValue}</td>
                            <td>${ob.fcstTime}</td>
                        </tr>`                        
                }
            }
        }
    })
}