<#import "layout/main_layout.ftlh" as macros>
<#import "layout/task_layout.ftlh" as taskLayout/>
<#import '/spring.ftl' as spring/>
<#assign dateFormat='dd MMM'/>
<@macros.mainLayout title="Projects" isAuth=true jsFiles=[]>
    <div class="d-container-fluid p-3 mt-2">
        <h3><b>Stats</b></h3>
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

    <div class="container-fluid p-3 d-flex flex-wrap">
        <#if !tasks?has_content>
            <div class="d-flex flex-column w-100 justify-content-center align-items-center">
                <img style="width: 160px" src="<@spring.url '/img/ic_no_task.png'/>" alt="no task">
                <h3 class="w-100 d-flex justify-content-center align-content-center">No tasks</h3>
            </div>
        </#if>

        <div class="card mt-2" style="width: 20rem;">
            <ul class="list-group">
                <#list tasks as task>
                    <@taskLayout.taskLayout task=task />
                </#list>
            </ul>
            <br>
        </div>
    </div>
</@macros.mainLayout>
