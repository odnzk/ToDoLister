document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('startDate').valueAsDate = new Date();
    const btnAdd = document.getElementById('addProject');
    const btnClear = document.getElementById('clearAll');
    const finishDateInput = document.getElementById("finishDate");
    finishDateInput.valueAsDate = new Date();

    function addProject() {
        $('#addProjectModal').modal('show');
    }

    const btnsDeleteProject = document.getElementsByClassName('deleteProjectBtn');
    for (let i = 0; i < btnsDeleteProject.length; i++) {
        btnsDeleteProject[i].addEventListener('click', (event) => {
            const projectId = btnsDeleteProject[i].id
            makeDeleteRequest(projectId)
        });
    }

    const btnsArchiveProject = document.getElementsByClassName('archiveBtn');
    for (let i = 0; i < btnsArchiveProject.length; i++) {
        btnsArchiveProject[i].addEventListener('click', (event) => {
            const projectId = btnsArchiveProject[i].id
            makeArchiveRequest(projectId)
        });
    }

    function makeDeleteRequest(id) {
        fetch(`/projects?id=${id}`, {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'}
        })
            .then(response => {
                window.location.href = '/projects'
            })
            .catch(error => {
                console.log("Error while deleting task")
            });
    }

    function makeArchiveRequest(id) {
        fetch(`/archive`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: {'projectId': id}
        })
            .catch(error => {
                console.log("Error while deleting task")
            });
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
