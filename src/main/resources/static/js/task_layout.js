document.addEventListener('DOMContentLoaded', event => {
    const taskLabelStyleClass = "completed-project-item"

    const elements = document.getElementsByClassName('deleteTaskBth');
    for (let i = 0; i < elements.length; i++) {
        elements[i].addEventListener('click', (event) => {
            const taskId = elements[i].id
            fetch(`/tasks?id=${taskId}`, {
                method: 'DELETE',
                headers: {'Content-Type': 'application/json'}
            })
                .then(response => {
                    window.location.href = '/projects'
                })
                .catch(error => {
                    console.log("Error while deleting task")
                });
        });
    }

    Array.from(document.getElementsByClassName('checkbox-project-item'))
        .forEach(cb => {
            cb.addEventListener('click', function () {
                updateTask(cb);
            });
        });

    function updateTask(checkbox) {
        const id = checkbox.classList.item(checkbox.classList.length - 1);
        const xhr = new XMLHttpRequest();
        xhr.open('PATCH', `/tasks?id=${id}`);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                const label = document.getElementById(`label-${id}`);
                if (label.classList.contains(taskLabelStyleClass)) {
                    label.classList.remove(taskLabelStyleClass)
                } else {
                    label.classList.add(taskLabelStyleClass)
                }
            }
        };
        xhr.send();
    }
});
