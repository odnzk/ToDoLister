<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>
<div class="d-flex w-100">
    <form method="post" action="login" class="w-50 p-5">
        <h1>Login</h1>
        <br>
<#--        todo-->
<#--        <#if requestScope.message?has_content>-->
<#--            <h2>${requestScope.message}</h2>-->
<#--        </#if>-->
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
        <input class="btn btn-primary" type="submit" value="Log in">
    </form>
</div>
</body>
</html>
