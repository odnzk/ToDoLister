document.addEventListener('DOMContentLoaded', event => {
    const inputField = document.getElementById("username");
    const myButton = document.getElementById("restorePasswordBtn");

    myButton.addEventListener("click", function () {
        const inputValue = inputField.value;
        if (inputValue === "") {
            alert("Username cannot be empty");
        } else {
            fetch("/reset", {
                method: "GET",
                body: JSON.stringify({username: inputValue}),
                headers: {"Content-Type": "application/json"}
            })
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                })
                .catch(error => {
                    console.error(error);
                });
        }
    });
});
