<#import "util/index.ftl" as index>

<@index.page>
    <section class="container">
        <form class="col-md-6 col-md-offset-3" method="POST" action="/login">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <#--<input type="hidden"-->
                   <#--name="${_csrf.parameterName}"-->
                   <#--value="${_csrf.token}"/>-->
            <button type="submit" value="class="btn btn-default">Login</button>
        </form>
    </section>
</@index.page>