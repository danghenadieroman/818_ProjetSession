/**
 *
 * @author Olena Lopatyuk
 */
var password = document.getElementById("pwd1")
        , confirm_password = document.getElementById("pwd2");
var btn = document.getElementById("btnSubmit");
var message = document.getElementById("errmessage").value;

function validate() {


    if (password.value != confirm_password.value) {
        confirm_password.setCustomValidity(message);
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validate;
confirm_password.onkeyup = validate;

