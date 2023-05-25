document.addEventListener('DOMContentLoaded', event => {
    const inputField = document.getElementById("username");
    const restoreBtn = document.getElementById("restorePasswordBtn");

    restoreBtn.addEventListener("click", function () {
        const inputValue = inputField.value;
        if (inputValue === "") {
            alert('Username cannot be empty');
        } else {
            window.location.href = `/restore?username=${encodeURIComponent(inputValue)}`
        }
    });
});
