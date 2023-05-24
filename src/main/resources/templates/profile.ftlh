<#import "layout/main_layout.ftlh" as mainLayout>
<@mainLayout.mainLayout title="Profile" isAuth=true jsFiles=["profile"]>
    <div class="d-container-fluid d-flex w-100 p-3 justify-content-center flex-column align-items-center">
        <form method="post" action="/profile" class="w-50 p-2">
            <input type="hidden" name=" ${_csrf.parameterName}" value="${_csrf.token}">
            <h3 class="w-100 d-flex justify-content-center"><b>Profile</b></h3>
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

            <input class="btn btn-primary w-100" type="submit" id="update" value="Change profile data">
        </form>
        <div class="w-50 p-2">
            <button class="btn btn-light w-100" id="logout">Logout</button>
        </div>
    </div>
</@mainLayout.mainLayout>
