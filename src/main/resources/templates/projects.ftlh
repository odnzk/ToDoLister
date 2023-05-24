<#import "layout/main_layout.ftlh" as macros>
<#import "part/form_add_task.ftlh" as formAddTask />
<#import "layout/task_layout.ftlh" as taskLayout/>
<#import '/spring.ftl' as spring/>
<@macros.mainLayout title="Projects" isAuth=true jsFiles=["projects"]>
    <#include "part/modal_add_project.ftlh">
    <#include "part/modal_confirm_action.ftlh">

    <div class="d-container-fluid p-3 mt-2">
        <h3 class=""><b>Projects</b></h3>
        <div class="d-flex justify-content-end">
            <button data-toggle="modal" data-target="#addProjectModal" id="addProject" type="button"
                    class="btn btn-primary pl-24 pr-24  mr-1"><i class="bi bi-plus"></i>
            </button>
            <button id="clearAll" type="button" class="btn btn-primary pl-24 pr-24"><i class="bi bi-trash-fill"></i>
            </button>
        </div>
    </div>

    <div class="container-fluid p-3 d-flex flex-wrap">
        <#if !projects?has_content>
            <div class="d-flex flex-column w-100 justify-content-center align-items-center">
                <img class="w-25" src="<@spring.url '/img/no-task.png'/>" alt="no task">
                <h3>You have not created projects yet</h3>
            </div>
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
