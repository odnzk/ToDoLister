<div class="modal fade" id="addProjectModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add project</h5>
            </div>
            <div class="modal-body">
                <form method="POST" action="/projects">
                    <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
                    <div>
                        <label for="title" class="form-label"><b>Title</b></label>
                        <input type="text" class="form-control" name="title" id="title"
                               placeholder="Enter title" required>
                    </div>
                    <div>
                        <label class="form-label" for="startDate"><b>Started</b></label>
                        <input class="form-control" placeholder="Enter start date"
                               type="date" name="startDate" id="startDate" required>
                    </div>

                    <div>
                        <label class="form-label" for="finishDate"><b>Deadline</b></label>
                        <input class="form-control" placeholder="Enter finish date"
                               type="date" name="finishDate" id="finishDate" required>
                    </div>
                    <br>

                    <input class="btn btn-primary w-100" type="submit" value="Add">
                </form>
            </div>
        </div>
    </div>
</div>
