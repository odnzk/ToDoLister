document.addEventListener('DOMContentLoaded', event => {
    const inputField = document.getElementById("username");
    const restoreBtn = document.getElementById("restorePasswordBtn");

    restoreBtn.addEventListener("click", function () {
        const inputValue = inputField.value;
        if (inputValue === "") {
            alert('Username cannot be empty');
        } else {
            fetch(`/restore?username=${encodeURIComponent(inputValue)}`, {
                method: 'GET',
                headers: {'Content-Type': 'application/json'}
            })
                .catch(error => {
                    console.error(error);
                });
        }
    });
});
