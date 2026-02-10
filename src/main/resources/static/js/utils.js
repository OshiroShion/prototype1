//HTTP request
async function HTTPRequest(reqData, address){
    try {
        //get csrf token
        const csrfToken = document.getElementById("csrfToken").value;
        const response = await fetch(address, {
           method: "POST",
           headers: {
               "Content-Type": "application/json",
               "X-CSRF-TOKEN": csrfToken
           },
           body: JSON.stringify(reqData)
        })
        const resData = await response.json();
        return resData;
    } catch (error) {
        console.error('Error occurred : ', error);
        return null;
    }
}

//reset message
function resetMsg(elementId){
    var msgElement = document.getElementById(elementId);
    while(msgElement.firstChild){
        msgElement.removeChild(msgElement.firstChild)
    }
}