<<#macro addTaskForm projectId>
    <form method="POST" action="/tasks" class="">
        <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
        <input type="hidden" name="projectId" value="${projectId}">
        <div>
            <label for="title"></label><input type="text" class="form-control" name="title"
                                              id="title"
                                              placeholder="New task" required>
        </div>
        <div class="w-100 d-flex justify-content-center">
            <div class="flex-fill">
                <input class="priority-low" type="radio" id="low" name="priority" value="Low" checked>
                <label for="Low">Low</label>
            </div>
            <div class="flex-fill">
                <input class="priority-medium" type="radio" id="medium" name="priority" value="Medium">
                <label for="medium">Medium</label>
            </div>
            <div class="flex-fill">
                <input class="priority-high" type="radio" id="high" name="priority" value="High">
                <label for="high">High</label>
            </div>
        </div>
        <input class="btn btn-outline-primary w-100" type="submit" value="Add">
    </form>
</#macro>
