<#import '/spring.ftl' as spring/>
<div class="w-100 d-flex flex-column justify-content-center align-items-center">
    <img style="width: 160px" src="<@spring.url '/img/ic_error.png'/>" alt="error">
    <h3 class="d-flex w-100 justify-content-center">${error}</h3>
</div>

