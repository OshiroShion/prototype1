// creating request data
document.getElementById('registerForm').onsubmit = function() {
    //get the roomId
    var roomIdClass = document.getElementsByClassName("room-id-form");
    var roomIdArr = Array.from(roomIdClass);
    var roomIdList = '';
    roomIdArr.forEach( (element, index) => {
        if(index != 0){
            roomIdList = roomIdList + ',';
        }
        roomIdList = roomIdList + element.value;
    });
    console.log(roomIdList);

    const form = document.querySelector('#registerForm');
    const formData = new FormData(form);

    // FormDataをプレーンなJavaScriptオブジェクトに変換
    const plainData = Object.fromEntries(formData.entries());

    // JSONにして送信
    fetch('/reservationRegister', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(plainData)
    });
}

// adding the form of room id
document.getElementById('add-button').onclick = function() {
    const container = document.getElementById('register-form');
    const newForm = container.querySelector('.input-group').cloneNode(true);
    newForm.querySelector('input').value = '';
    container.appendChild(newForm);
};

// deleting the form of room id
document.addEventListener('click', function(e) {
    if (e.target && e.target.classList.contains('remove-button')) {
        if (document.querySelectorAll('.input-group').length > 1) {
            e.target.closest('.input-group').remove();
        }
    }
});