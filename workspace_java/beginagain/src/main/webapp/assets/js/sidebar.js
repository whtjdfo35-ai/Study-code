window.addEventListener('load', init)

function init() {

    const logoutBtn = document.getElementById('logoutBtn');
    const pageMainTitle = document.getElementById('pageMainTitle');
    const pageSubTitle = document.getElementById('pageSubTitle');

    const navHome = document.querySelector('.nav-home');
    const menuTitles = document.querySelectorAll('.menu-title');
    const pageSections = document.querySelectorAll('.page-section');
    const submenuButtons = document.querySelectorAll('.menu-items button');

    const profileModal = document.getElementById('profileModal');
    const openProfileBtn = document.getElementById('openProfileBtn');
    const closeProfileBtn = document.getElementById('closeProfileBtn');
    const toast = document.getElementById('toast');


    /* 실시간 시계 */
    const liveCalendar = document.getElementById('liveCalendar');
    const liveClock = document.getElementById('liveClock');

    function updateClock() {
        const now = new Date();
        const y = now.getFullYear();
        const m = String(now.getMonth() + 1).padStart(2, '0');
        const d = String(now.getDate()).padStart(2, '0');
        const h = String(now.getHours()).padStart(2, '0');
        const mi = String(now.getMinutes()).padStart(2, '0');
        const s = String(now.getSeconds()).padStart(2, '0');

        const week = ['일', '월', '화', '수', '목', '금', '토']
        const w = week[now.getDay()]

        liveCalendar.textContent = `${y}-${m}-${d} ${w}요일`
        liveClock.textContent = `${h} : ${mi} : ${s}`
    }
    updateClock();
    setInterval(updateClock, 1000);

    document.getElementById('menuToggle').addEventListener('click', () => {        
        document.querySelector('.sidebar').classList.toggle('open')
    })

    /*  
        토스트 알림 함수
        로그인 성공, 메뉴 이동 등 짧은 알림 메시지를 우측 하단에 띄운다.       
    */
    let toastTimer = null;
    function showToast(message) {
        toast.textContent = message;
        toast.classList.add('show');

        clearTimeout(toastTimer);
        toastTimer = setTimeout(() => {
            toast.classList.remove('show');
        }, 2200);
    }

    

    /* 로그아웃 버튼 눌렀을 때   */

    logoutBtn.addEventListener('click', () => {
        document.querySelector('.app').classList.add('hidden');        
        showToast('로그아웃되었습니다.');
    });

    /*
        좌측 메뉴 클릭 이벤트
        대시보드 단일 버튼
        각 소메뉴 버튼       
    */
    navHome.addEventListener('click', () => {
        activatePage('dashboard');
    });

    submenuButtons.forEach(button => {
        button.addEventListener('click', () => {
            activatePage(button.dataset.page);
        });
    });

    /*
        메뉴 그룹 열기 / 닫기       
    */
    menuTitles.forEach(titleBtn => {
        titleBtn.addEventListener('click', () => {
            titleBtn.classList.toggle('open');
            const menuItems = titleBtn.nextElementSibling;
            if (menuItems) {
                menuItems.classList.toggle('open');
            }
        });
    });

    
}


