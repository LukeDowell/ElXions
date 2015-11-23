<#import "views/index.ftl" as home>

<@home.page>
<section class="container">
    <div class="jumbotron">
        <#list electionList>
            <#items as election>
                <h1>${election.title}</h1>
                <#list election.races>
                    <#items as race>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">${race.title}</h3>
                        </div>
                        <div class="panel-body">
                            <#list race.candidates>
                                <#items as game>
                                    <div class="well col-md-1 col-md-offset-1 text-center">
                                        ${game.title}
                                        <button type="button" class="btn btn-primary">Vote</button>
                                    </div>
                                </#items>
                            </#list>
                        </div>
                    </div>
                    </#items>
                </#list>
            </#items>
        </#list>
    </div>
</section>
</@home.page>