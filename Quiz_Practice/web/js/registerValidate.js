
function validateEmail() {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//  var re = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
    let email = document.getElementById("email").value;
//    return re.test(String(email).toLowerCase());
    if (!email){
        document.getElementById("emailvalid").innerHTML = "Email cannot be empty !";
        return false;
    }else if(!re.test(String(email).toLowerCase())){
        document.getElementById("emailvalid").innerHTML = "Invalid email format(example@domain.domain...)";
        return false;
    }else {
        document.getElementById("emailvalid").innerHTML = "";
        return true;
    }
}

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
        document.getElementById("dobvalid").innerHTML = "You must have more than 15 years old from today to take the register !";
        return false;
    } else if (dob <= eighttyYearsAgo) {
        document.getElementById("dobvalid").innerHTML = "You must have less than 80 years old from today to take the register !";
        return false;
    } else {
        document.getElementById("dobvalid").innerHTML = "";
        return true;
    }
}

function validateAddress(){
    let address = document.getElementById("address").value;
    if(!address){
        document.getElementById("addressvalid").innerHTML = "Your Address must be filled out !";
        return false;
    }else {
        document.getElementById("addressvalid").innerHTML ="";
        return true;
    }
}

function validatePassword(){
    let pass = document.getElementById("pass").value;
    if(!pass){
        document.getElementById("passvalid").innerHTML = "Your password must be filled out !";
        return false;
    }else {
        document.getElementById("passvalid").innerHTML ="";
        return true;
    }
}

function validateRePass(){
    let repass = document.getElementById("repass").value;
    let pass = document.getElementById("pass").value;
    if(pass!==repass){
        document.getElementById("repassvalid").innerHTML = "Your re-typed password must be same as your password !";
        return false;
    }else {
        document.getElementById("repassvalid").innerHTML ="";
        return true;
    }
}
function validate() {
  let fname = document.getElementById("fname").value;
  const dob = new Date(document.getElementById("dob").value);
  let email = document.getElementById("email").value;
  let pass = document.getElementById("pass").value;
  let repass = document.getElementById("repass").value;
  let phone = document.getElementById("phone").value;
  let address = document.getElementById("address").value;
  
  if(!fname || !dob || !email || !pass || !repass || !phone || !address){
        document.getElementById("mess").innerHTML = "Please fill in all fields";
  }
  if(validateEmail() && validateName() && validateNumber() && validateDob() && validateAddress() && validatePassword() && validateRePass()) {
    document.getElementById("register").submit();
    return;
  }
}


//function validate() {
//  let fname = document.getElementById("fname").value;
//  const dob = new Date(document.getElementById("dob").value);
//  let email = document.getElementById("email").value;
//  let pass = document.getElementById("pass").value;
//  let repass = document.getElementById("repass").value;
//  let phone = document.getElementById("phone").value;
//  let address = document.getElementById("address").value;
//  if (!validateName(fname)) {
//  } else if (!validateDate(dob)) {
//  } else if (!validateNumber(phone)) {
//  } else if (!validateEmail(email)) {
//    document.getElementById("mess").innerHTML = "Invalid email format(example@domain.domain.domain...)";
//  } else if (address == "") {
//    document.getElementById("mess").innerHTML = "Your Address must be filled out !"
//  } else if (pass == "") {
//    document.getElementById("mess").innerHTML = "Your password must be filled out !";
//  } else if (pass !== repass) {
//    document.getElementById("mess").innerHTML = "Your re-typed password must be same as your password !";
//  } else {
//    document.getElementById("register").submit();
//  }
//}

