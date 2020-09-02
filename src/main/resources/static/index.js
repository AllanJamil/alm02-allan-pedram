$(document).ready(function () {

    $("#btn-fortune").click(function () {
        let person = {fullName: $("#fullName").val(), nationality: $("#nationality").val(), age: $("#age").val(), gender: $("#gender").val()}
        console.log(person)
        post(person);

    });

    function post(person) {
        let xhr = new XMLHttpRequest();
        let theUrl = "http://localhost:8081/fortune/api/cookie";
        xhr.open("POST", theUrl);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhr.send(JSON.stringify(person));

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                let fortune = JSON.parse(xhr.response).fortune;
                displayFortune(fortune)
            }
        }
    }

    function displayFortune(fortune) {
        $("#display").text(fortune);
    }

});