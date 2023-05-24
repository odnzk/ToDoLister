<div class="d-flex w-100 justify-content-center">
    <form method="post" action="/restore" class="w-50 p-5">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <h1>Reset password</h1>
        <br>
        <input type="hidden" name="username" value="${username}">
        <div class="mb-3">
            <label class="form-label" for="password">Password</label>
            <input class="form-control" placeholder="Enter password" type="password" name="password"
                   id="password"
                   required>
        </div>
        <input class="btn btn-primary" type="submit" value="Log in">
    </form>
    <button class="btn btn-primary">Reset password</button>
</div>
