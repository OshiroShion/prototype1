//Event when register button is clicked-----------------------------------
document.getElementById('modal-button-register').onclick = function() {

    //input check
    if(check()){
        return;
    }

    //reset messages
    resetMsg('msgUserName');
    resetMsg('msgPassword');
    resetMsg('msgPasswordRetyped');
    resetMsg('msgPosition');
    resetMsg('msgRole');

    //update items in confirm window
    updateConfirmWindow();

    //open modal
    const modalRegister = new bootstrap.Modal('#modal-register');
    modalRegister.show();
}


//Event when yes is clicked in confirm window(HTTP request)-----------------------------------
document.getElementById('register').onclick = async function() {

    //get elements
    var userName = document.getElementById('userName');
    var password = document.getElementById('password');
    var passwordRetyped = document.getElementById('passwordRetyped');
    var position = document.getElementById('position');
    var role = document.getElementById('role');
    var registerButton = document.getElementById('modal-button-register');
    var header = document.getElementById('header');

    //form request data(ReqData)
    const req = {
        userName: userName.value,
        password: password.value,
        position: position.value,
        role: role.value
    };

    //HTTP request
    const res = await HTTPRequest(req, "/userRegister");

    //add userId
    var userIdlabel = document.createElement('label');
    userIdlabel.textContent = 'user id';

    var userIdInput = document.createElement('input');
    userIdInput.type = 'text';
    userIdInput.value = res.userId;
    userIdInput.className = 'form-control mb-1';
    userIdInput.disabled = true;

    userIdDisplay = document.getElementById('input-form');
    userIdDisplay.prepend(userIdInput);
    userIdDisplay.prepend(userIdlabel);

    //disable forms
    userName.disabled = true;
    password.disabled = true;
    passwordRetyped.disabled = true;
    position.disabled = true;
    role.disabled = true;
    role.disabled = true;
    registerButton.disabled = true;

    //change header
    header.textContent = 'user register completed';
}


//functions-------------------------------------------------

//update items in confirm window
function updateConfirmWindow(){

    //get elements
    var userName = document.getElementById('userName');
    var position = document.getElementById('position');
    var role = document.getElementById('role');

    var userNameConfirm = document.getElementById('username-confirm');
    var positionConfirm = document.getElementById('position-confirm');
    var roleConfirm = document.getElementById('role-confirm')
    var roleText = '';
    switch(role.value){
        case 'ROLE_USER':
            roleText = 'user';
        case 'ROLE_ADMIN':
            roleText = 'admin';
    }

    //update elements
    userNameConfirm.textContent = userName.value;
    positionConfirm.textContent = position.value;
    roleConfirm.textContent = roleText;
}

//input check
function check(){

    var errFlg = false;

    //get input elements
    var userName = document.getElementById('userName').value;
    var password = document.getElementById('password').value;
    var passwordRetyped = document.getElementById('passwordRetyped').value;
    var position = document.getElementById('position').value;
    var role = document.getElementById('role').value;

    //get msg elements
    var msgUserName = document.getElementById('msgUserName');
    var msgPassword = document.getElementById('msgPassword');
    var msgPasswordRetyped = document.getElementById('msgPasswordRetyped');
    var msgPosition = document.getElementById('msgPosition');
    var msgRole = document.getElementById('msgRole');

    //----------------required check-----------------
    var msg = 'This form is required';
    if(userName == ''){
        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgUserName.appendChild(errMsg);
        errFlg = true;
    }
    if(password == ''){
        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgPassword.appendChild(errMsg);
        errFlg = true;
    }
    if(passwordRetyped == ''){
        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgPasswordRetyped.appendChild(errMsg);
        errFlg = true;
    }
    if(position == ''){
        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgPosition.appendChild(errMsg);
        errFlg = true;
    }
    if(role == ''){
        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgRole.appendChild(errMsg);
        errFlg = true;
    }

    //----------------compare password and retyped password----------------
    msg = 'This does not match the password you typed above' ;
    if( password != '' &&
        passwordRetyped != '' &&
        password != passwordRetyped){

        let errMsg = document.createElement('div');
        errMsg.textContent = msg;
        msgPasswordRetyped.appendChild(errMsg);
        errFlg = true;
    }

    return errFlg;
}