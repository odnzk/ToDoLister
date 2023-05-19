<#macro taskLayout task>
    <li class="list-group-item">
        <div class="form-check">
            <input class="form-check-input checkbox-project-item ${task.id}"
                   type="checkbox" value="" <#if task.isCompleted>checked</#if>
            >
            <label class="form-check-label project-item-label <#if task.isCompleted>completed-project-item</#if>">
                ${task.title}
            </label>
            <#--        todo check action url ?? -->
            <a class="" href="/delete?id=${task.id}">
                <i class="bi bi-dash-square-fill float-end"></i>
            </a>
        </div>
    </li>
</#macro>
