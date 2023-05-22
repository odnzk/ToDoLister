<#import "layout/main_layout.ftlh" as macros>
<#import "part/modal_add_project.ftlh" as modalAddProject/>
<#import "part/modal_confirm_action.ftlh" as modalConfirmAction />
<#import "part/form_add_task.ftlh" as formAddTask />
<#import "layout/task_layout.ftlh" as taskLayout/>
<@macros.mainLayout title="Projects" isAuth=true>
<#--    <@modalAddProject/> todo -->
<#--    todo <@modalConfirmAction.modalConfirmAction actionTitle="Delete all project" actionUrl="" />-->

    <div class="d-container-fluid p-3 mt-2">
        <h3 class=""><b>Projects</b></h3>
        <div class="d-flex justify-content-end">
            <#--            todo show modal-->
            <button data-toggle="modal" data-target="#addProjectModal" id="addProject" type="button"
                    class="btn btn-primary pl-24 pr-24  mr-1"><i class="bi bi-plus"></i>
            </button>
            <#--            todo show modal-->
            <button id="clearAll" type="button" class="btn btn-primary pl-24 pr-24"><i class="bi bi-trash-fill"></i>
            </button>
        </div>
    </div>

    <div class="container-fluid p-3 d-flex flex-wrap">
        <#if !projects?has_content>
            <h3>You have not created projects yet</h3>
        </#if>
        <#list projects as project>
            <div class="card mt-2" style="width: 20rem;">
                <div class="card-body">
                    <#--                    todo change method to ="DELETE"-->
                    <a class="" href="/delete?id=${project.id}">
                        <i class="bi bi-x-square-fill float-end"></i>
                    </a>

                    <h5 class="card-title">${project.title}</h5>

                    <p class=""><b>Deadline:</b> ${project.deadlineDate}</p>

                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar"
                             style="width: ${project.progress}%" aria-valuenow="${project.progress}"
                             aria-valuemin="0" aria-valuemax="100">${project.progress}%
                        </div>
                    </div>

                    </br>
                    <ul class="list-group">
                        <#list project.tasks as task>
                            <@taskLayout.taskLayout task=task />
                        </#list>
                    </ul>
                    <br>
                    <@formAddTask.addTaskForm projectId=project.id />
                </div>
            </div>
        </#list>
    </div>
</@macros.mainLayout>
