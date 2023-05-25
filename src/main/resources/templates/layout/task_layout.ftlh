<#macro taskLayout task isRemovingEnable>
    <li class="list-group-item w-100">
        <div class="form-check w-100">
            <input class="priority-${task.priority.key} checkbox-project-item ${task.id}"
                   type="checkbox" value="" <#if task.isCompleted?string == 'true'>checked</#if>>
            <label id="label-${task.id}" class="w-75 form-check-label project-item-label
            <#if task.isCompleted?string == 'true'>completed-project-item</#if>">${task.title}</label>
            <#if isRemovingEnable> <i id="${task.id}" class="bi bi-dash-square-fill float-end deleteTaskBth"></i></#if>
        </div>
    </li>
</#macro>
