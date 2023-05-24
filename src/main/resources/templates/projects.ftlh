<#import "layout/main_layout.ftlh" as macros>
<#import "part/form_add_task.ftlh" as formAddTask />
<#import "layout/task_layout.ftlh" as taskLayout/>
<#import '/spring.ftl' as spring/>
<#assign dateFormat='dd MMM'/>
<@macros.mainLayout title="Projects" isAuth=true jsFiles=["projects", "task_layout"]>
    <#include "part/modal_add_project.ftlh">
    <#include "part/modal_confirm_action.ftlh">

    <div class="d-container-fluid p-3 mt-2">
        <h3><b>Projects</b></h3>
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
                <img style="width: 160px" src="<@spring.url '/img/ic_no_task.png'/>" alt="no task">
                <h3 class="w-100 d-flex justify-content-center align-content-center">You have not created projects
                    yet</h3>
            </div>
        </#if>
        <#list projects as project>
            <div class="card mt-2" style="width: 20rem;">
                <div class="card-body">
                    <i id="${project.id}" class="${project.id} bi bi-x-square-fill float-end deleteProjectBtn"></i>
                    <i id="${project.id}" class="bi bi-save2-fill float-start archiveBtn"></i>

                    <p class="d-flex justify-content-center w-100">
                        ${project.startDate?string(dateFormat)} - ${project.deadlineDate?string(dateFormat)}
                    </p>

                    <h5 class="card-title d-flex justify-content-center w-100">${project.title}</h5>
                    <br>
                    <#if project.tasks?has_content>
                        <ul class="list-group">
                            <#list project.tasks as taskEntity>
                                <@taskLayout.taskLayout task=taskEntity />
                            </#list>
                        </ul>
                        <br>
                    </#if>
                    <@formAddTask.addTaskForm projectId=project.id />
                </div>
            </div>
        </#list>
    </div>
</@macros.mainLayout>
