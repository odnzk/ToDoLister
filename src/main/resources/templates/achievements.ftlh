<#import "layout/main_layout.ftlh" as macros>
<@macros.mainLayout title="Achievements" isAuth=true jsFiles=[]>
    <div class="d-container-fluid p-3">
        <h1>Achievements</h1>
        <#list categories as category>
            <h4>Category: ${category}</h4>
            <div class="card" style="width: 100%">
                <ul class="list-group list-group-flush">
                    <#list achievements as achievement>
                        <#if achievement.category == category>
                            <li class="list-group-item d-flex <#if !achievement.unlocked>disabled</#if>">
                                <i class="bi bi-award-fill"></i>
                                <p class="ms-3">${achievement.achievement.title}</p>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <br>
        </#list>
    </div>
</@macros.mainLayout>
