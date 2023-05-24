<#import '/spring.ftl' as spring/>
<#import "layout/main_layout.ftlh" as macros>
<@macros.mainLayout title="Achievements" isAuth=true jsFiles=[]>
    <div class="d-container-fluid p-3">
        <h3><b>Achievements</b></h3>
        <#list categories as category>
            <h4>${category}</h4>
            <div class="card" style="width: 100%">
                <ul class="list-group list-group-flush">
                    <#list achievements as achievement>
                        <#if achievement.category == category>
                            <li class="d-flex list-group-item <#if !achievement.isUnlocked>disabled</#if>">
                                <img style="width: 40px" src="<@spring.url '/img/ic_achievement.png'/>"
                                     alt="achievement">
                                <p class="w-100">${achievement.title}</p>
                            </li>
                        </#if>
                    </#list>
                </ul>
            </div>
            <br>
        </#list>
    </div>
</@macros.mainLayout>
