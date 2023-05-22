<#import "layout/main_layout.ftlh" as mainLayout>
<@mainLayout.mainLayout title="Profile">
    <div class="d-container-fluid d-flex w-100 p-3">

        <form method="post" action="update" class="w-50 p-5">
            <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
            <h1>Profile</h1>
            <br>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Username</span>
                <input type="text" class="form-control"
                       placeholder="${user.username!''}"
                       value="${user.username!''}"
                       maxlength="25" name="username"
                       aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon2">Email</span>
                <input type="text" class="form-control"
                       aria-label="Email" aria-describedby="basic-addon1"
                       placeholder="${user.email!''}"
                       value="${user.email!''}"
                       name="email" maxlength="30">
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon3">Password</span>
                <input type="password" class="form-control"
                       aria-label="Email" aria-describedby="basic-addon3"
                       name="password" maxlength="30" disabled
                       placeholder="${user.password!''}" value="${user.password!''}">
            </div>

            <input class="btn btn-primary w-100" type="submit" value="Change profile data">
            <br><br>
<#--            todo logout-->
            <button class="btn btn-primary w-100" id="logout">Logout</button>
            <#--            todo delete-->
            <button class="btn btn-primary w-100" id="delete">Delete</button>
        </form>
    </div>
</@mainLayout.mainLayout>
