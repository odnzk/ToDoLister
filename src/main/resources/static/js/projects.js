document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('startDate').valueAsDate = new Date();
    const btnAdd = document.getElementById('addProject');
    const btnClear = document.getElementById('clearAll');
    const btnDeleteProject = document.getElementById('deleteProjectBtn');
    const finishDateInput = document.getElementById("finishDate");
    finishDateInput.valueAsDate = new Date();

    function addProject() {
        $('#addProjectModal').modal('show');
    }

    function makeDeleteRequest(id) {
        const form = document.createElement('form');
        form.method = 'DELETE';
        form.action = '/projects';
        form.append('id', id)
        document.body.appendChild(form);
        form.submit();
    }

    function deleteProject(id) {
        if (id === -1) {
            if (confirm('Are you sure?')) {
                makeDeleteRequest(id)
            } else {
                window.location.href = '/projects';
            }
        } else {
            makeDeleteRequest(id)
        }
    }

    if (btnAdd) {
        btnAdd.addEventListener('click', addProject);
    }
    if (btnClear) {
        btnClear.addEventListener('click', function () {
            deleteProject(-1)
        });
    }
    if (btnDeleteProject) {
        btnDeleteProject.addEventListener('click', function () {
            const id = btnDeleteProject.classList.item(0)
            deleteProject(id)
        })
    }

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
