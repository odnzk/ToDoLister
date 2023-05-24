<<#macro addTaskForm projectId>
<#-- todo check url -->
    <form method="post" action="add" class="">
        <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
        <input type="text" class="invisible" name="projectId" value="${projectId}">
        <div>
            <label for="projectItemTitle"></label><input type="text" class="form-control" name="title" id="projectItemTitle"
                                                         placeholder="Enter new project item" required>
        </div>

        <div class="d-flex flex-column w-100 align-content-center">
            <label for="Low">Low</label><br>
            <label for="low"></label><input type="radio" id="low" name="priority" value="Low">
            <label for="medium">High</label><br>
            <input type="radio" id="medium" name="priority" value="Medium">
            <label for="high">High</label><br>
            <input type="radio" id="high" name="priority" value="High">
        </div>

        <input class="btn btn-primary float-end" type="submit" value="Add">
    </form>
</#macro>
