<#import "layout/main_layout.ftlh" as macros>
<#import "layout/task_layout.ftlh" as taskLayout/>
<#import '/spring.ftl' as spring/>
<#assign dateFormat='dd MMM'/>
<@macros.mainLayout title="Projects" isAuth=true jsFiles=[]>
    <div class="d-container-fluid p-3 mt-2">
        <h3><b>Stats</b></h3>
    </div>
    <h3 class="p-3">Tasks</h3>
    <p class="ps-5 pe-5"><b>Priority</b></p>
    <div class="ps-5 pe-5 card d-flex">
        <div>
            <input class="priority-low" type="radio" id="low" name="priority" value="Low" checked>
            <label for="Low">Low</label>
        </div>
        <div>
            <input class="priority-medium" type="radio" id="medium" name="priority" value="Medium">
            <label for="medium">Medium</label>
        </div>
        <div>
            <input class="priority-high" type="radio" id="high" name="priority" value="High">
            <label for="high">High</label>
        </div>
    </div>
    <br>
    <br>
    <div class="container-fluid p-3">
        <#if !tasks?has_content>
            <h3 class="w-100 d-flex justify-content-center align-items-center">No tasks for this filters</h3>
        <#else>
            <ul class="w-100 list-group">
                <#list tasks as task>
                    <@taskLayout.taskLayout task=task isRemovingEnable=false />
                </#list>
            </ul>
            <br>
        </#if>
    </div>

    <div class="p-3">
        <h3>Archived projects</h3>
        <br>
        <#list projects as project>
            <div class="card mt-2" style="width: 20rem;">
                <div class="card-body">
                    <p class="d-flex justify-content-center w-100">
                        ${project.startDate?string(dateFormat)} - ${project.deadlineDate?string(dateFormat)}
                    </p>
                    <h5 class="card-title d-flex justify-content-center w-100">${project.title}</h5>
                    <p class="d-flex justify-content-center w-100">
                        ${project.completedTasksCount}/${project.tasksCount}
                    </p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar"
                             style="width: ${project.progress}%" aria-valuenow="${project.progress}"
                             aria-valuemin="0" aria-valuemax="100">${project.progress}%
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@macros.mainLayout>
