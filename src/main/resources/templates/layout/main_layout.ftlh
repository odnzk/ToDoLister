<#import '/spring.ftl' as spring/>
<#macro mainLayout title, isAuth, jsFiles>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="<@spring.url '/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <title>${title}</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light  bg-primary">
        <a class="navbar-brand ps-2" href="#"><b>TodoLister</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <#if isAuth>
                    <li class="nav-item active"><a class="nav-link" href="/projects">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/achievements">Achievements</a></li>
                    <li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="/stats">Stats</a></li>
                <#else>
                    <li class="nav-item"><a class="nav-link" href="/signup">Signup</a></li>
                    <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                </#if>
            </ul>
        </div>
    </nav>

    <#nested>


    <script src="<@spring.url '/js/bootstrap.min.js'/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <#list jsFiles as file>
        <script src="<@spring.url '/js/${file}.js' />"></script>
    </#list>
    </body>
    </html>
</#macro>
