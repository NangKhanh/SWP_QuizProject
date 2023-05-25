/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateName() {
    let fname = document.getElementById("fname").value;
    const regex = /^[a-zA-Z\s]+$/;
    if (!fname) {
        document.getElementById("namevalid").innerHTML = "Name cannot be empty !";
        return false;
    } else if (!regex.test(fname)) {
        document.getElementById("namevalid").innerHTML = "Name should only contain letters and spaces ! <br/>";
        return false;
    } else {
        document.getElementById("namevalid").innerHTML = "";
        return true;
    }
}
function validateNumber() {
    //const regex = /^\d{10}$/;
    let phone = document.getElementById("phone").value;
    const regex = /^(\+\d{1,4}\s?)?\d{10}$/;
    if (!phone) {
        document.getElementById("phonevalid").innerHTML = "Your phone number cannot be empty !";
        return false;
    } else if (!regex.test(phone)) {
        document.getElementById("phonevalid").innerHTML = "Number should contain exactly 10 digits and country code!";
        return false;
    } else {
        document.getElementById("phonevalid").innerHTML = "";
        return true;
    }
}

function validateDob() {
    const today = new Date();
    const eighttyYearsAgo = new Date(today.getFullYear() - 80, today.getMonth(), today.getDate());
    const fifteenYearsAgo = new Date(today.getFullYear() - 15, today.getMonth(), today.getDate());
    const dob = new Date(document.getElementById("dob").value);
    if (dob == "Invalid Date") {
        document.getElementById("dobvalid").innerHTML = "Your date of birth cannot be empty";
        return false;
    } else if (dob >= fifteenYearsAgo) {
        document.getElementById("dobvalid").innerHTML = "You must have more than 15 years old from today !";
        return false;
    } else if (dob <= eighttyYearsAgo) {
        document.getElementById("dobvalid").innerHTML = "You must have less than 80 years old from <br> today !";
        return false;
    } else {
        document.getElementById("dobvalid").innerHTML = "";
        return true;
    }
}

function validateAddress() {
    let address = document.getElementById("address").value;
    if (!address) {
        document.getElementById("addressvalid").innerHTML = "Your Address must be filled out !";
        return false;
    } else {
        document.getElementById("addressvalid").innerHTML = "";
        return true;
    }
}

function validate() {
    let fname = document.getElementById("fname").value;
    const dob = new Date(document.getElementById("dob").value);
    let phone = document.getElementById("phone").value;
    let address = document.getElementById("address").value;

    if (!fname || !dob || !phone || !address) {
        document.getElementById("mess").innerHTML = "Please fill in all fields";
    }
    if (validateName() && validateNumber() && validateDob() && validateAddress()) {
        document.getElementById("mess").innerHTML = "";
        document.getElementById("update").submit();
        alert("Update succesfull !");
        return;
    }
}