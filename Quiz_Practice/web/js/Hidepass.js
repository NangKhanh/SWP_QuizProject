let x = true;
let y = true;
function showpass() {
    if (x) {
        document.getElementById('pass').type = 'text';
        x = false;
    } else {
        document.getElementById('pass').type = 'password';
        x = true;
    }
}

function confirmpass() {
    if (y) {
        document.getElementById('repass').type = 'text';
        y = false;
    } else {
        document.getElementById('repass').type = 'password';
        y = true;
    }
}