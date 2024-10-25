document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');

    // 간단한 유효성 검사
    if (email === "user@example.com" && password === "password123") {
        // 로그인 성공 시 로그아웃 페이지로 리다이렉트
        window.location.href = 'logout.html';
    } else {
        message.style.color = "red";
        message.textContent = "이메일 또는 비밀번호가 잘못되었습니다.";
    }
});