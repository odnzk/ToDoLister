<<#macro addTaskForm projectId>
<#-- todo check url -->
    <form method="post" action="add" class="">
        <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
        <input type="text" class="invisible" name="projectId" value="${projectId}">
        <div>
            <input type="text" class="form-control" name="title" id="projectItemTitle"
                   placeholder="Enter new project item" required>
        </div>
        <input class="btn btn-primary float-end" type="submit" value="Add">
        <#--        todo priority -->
    </form>
</#macro>
