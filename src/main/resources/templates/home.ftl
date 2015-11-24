<#import "views/index.ftl" as home>

<@home.page>
    <section class="container" ng-controller="HomeController">
        <div class="jumbotron">
            <h1>You are logged in!</h1>
        </div>
    </section>
</@home.page>