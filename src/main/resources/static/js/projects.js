document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('startDate').valueAsDate = new Date();
    const btnAdd = document.getElementById('addProject');
    const btnClear = document.getElementById('clearAll');
    const finishDateInput = document.getElementById("finishDate");
    finishDateInput.valueAsDate = new Date();

    function addProject() {
        $('#addProjectModal').modal('show');
    }

    function clearAllProjects() {
        if (confirm('Are you sure?')) {
            const form = document.createElement('form');
            form.method = 'DELETE';
            form.action = '/projects';
            form.append('id', 1)
            document.body.appendChild(form);
            form.submit();
        } else {
            window.location.href = '/projects';
        }
    }

    function updateTask(checkbox) {
        const id = checkbox.classList.item(checkbox.classList.length - 1);
        const xhr = new XMLHttpRequest();
        xhr.open('PATCH', `/update?id=${id}`);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                // do something with the response, if needed
                // todo
            }
        };
        xhr.send();
    }

    if (btnAdd) {
        btnAdd.addEventListener('click', addProject);
    }
    if (btnClear) {
        btnClear.addEventListener('click', clearAllProjects);
    }

    Array.from(document.getElementsByClassName('checkbox-project-item'))
        .forEach(cb => {
            cb.addEventListener('click', function () {
                updateTask(cb);
            });
        });

    finishDateInput.addEventListener("input", function () {
        const startDate = document.getElementById('startDate').valueAsDate;
        const selectedDate = new Date(this.value);

        if (selectedDate < startDate) {
            this.setCustomValidity("Deadline must be greater than start date");
        } else {
            this.setCustomValidity("");
        }
    });
});
