// HTTP request
document.getElementById('submit').onclick = async function() {
    //form roomList
    var roomIdClass = document.getElementsByClassName("room-id-form");
    var roomIdArr = Array.from(roomIdClass);
    var roomList = new Array(roomIdArr.length);
    roomIdArr.forEach( (element, index) => {
        var room = {roomId: element.value};
        roomList[index] = room;
    });

    //form request data(ReqData)
    const reqData = {
        roomList: roomList,
        guestName: document.getElementById('guestName').value,
        guestPhone: document.getElementById('guestPhone').value,
        guestEmail: document.getElementById('guestEmail').value,
        adultCount: document.getElementById('adultCount').value,
        childCount: document.getElementById('childCount').value,
        checkInDate: document.getElementById('checkInDate').value,
        checkOutDate: document.getElementById('checkOutDate').value
    };

    //HTTP request
    const resData = await HTTPRequest(reqData);
    console.log(resData, "/reservationRegister");
}

// add roomId form
document.getElementById('add-button').onclick = function() {
    const container = document.getElementById('register-form');
    const newForm = container.querySelector('.input-group').cloneNode(true);
    newForm.querySelector('input').value = '';
    container.appendChild(newForm);
};

// delete roomId form
document.addEventListener('click', function(e) {
    if (e.target && e.target.classList.contains('remove-button')) {
        if (document.querySelectorAll('.input-group').length > 1) {
            e.target.closest('.input-group').remove();
        }
    }
});