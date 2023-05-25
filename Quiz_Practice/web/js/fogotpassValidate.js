
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
  }
function validate() {
    let email = document.getElementById("email").value;
  if (!validateEmail(email)) {
      document.getElementById("mess").innerHTML = "Invalid email format(example@domain..domain.domain...)";
    } else {
      document.getElementById("register").submit();
    }
  }
  
