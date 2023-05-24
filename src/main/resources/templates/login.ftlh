<#import "layout/main_layout.ftlh" as macros>
<@macros.mainLayout title="Login" isAuth=false jsFiles=["login"]>
    <div class="d-flex align-items-center justify-content-center">
        <form method="post" action="/login" class="w-50 p-5">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <h1 class="d-flex w-100 justify-content-center">Login</h1>
            <br>
            <div>
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="username"
                       placeholder="Enter username" required>
            </div>
            <div class="mb-3">
                <label class="form-label" for="password">Password</label>
                <input class="form-control" placeholder="Enter password" type="password" name="password"
                       id="password"
                       required>
            </div>
            <input class="btn btn-primary w-100" type="submit" value="Log in">
            <button class="w-100 btn btn-light" id="restorePasswordBtn">Forgot password</button>
        </form>
    </div>
</@macros.mainLayout>
