/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const minutes = 20;
let someMinutesLater = new Date();
const storedEndTime = window.localStorage.getItem('countdownEndTime');
if (storedEndTime) {
    someMinutesLater = new Date(storedEndTime);
} else {
    someMinutesLater.setMinutes(someMinutesLater.getMinutes() + minutes);
}

const countdownElement = document.getElementById('countdown');
const countdownInterval = setInterval(() => {
    const remainingTime = someMinutesLater - new Date();

    if (remainingTime <= 0) {
        clearInterval(countdownInterval);
        alert("Time is up ! Let's see your result");
        countdownElement.textContent = 'Time is up!';
        window.localStorage.removeItem('countdownEndTime');
        document.getElementById("quizresult").submit();
        return;
    }

    const remainingMinutes = Math.floor(remainingTime / (60 * 1000));
    const remainingSeconds = Math.floor((remainingTime % (60 * 1000)) / 1000);
    countdownElement.textContent = `Time remaining: ` + remainingMinutes + `:` + remainingSeconds.toString().padStart(2, '0');

    window.localStorage.setItem('countdownEndTime', someMinutesLater);
}, 1000);

function getresult() {
    window.localStorage.removeItem('countdownEndTime');
    document.getElementById("quizresult").submit();
}