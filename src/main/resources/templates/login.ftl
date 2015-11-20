<#import "views/index.ftl" as home>

<@home.page>
    <section class="container">
        <form class="col-md-6 col-md-offset-3">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password">
            </div>
            <button type="submit" class="btn btn-default">Login</button>
        </form>
    </section>
</@home.page>