<#import "util/index.ftl" as index>

<@index.page>
<section class="container">
        <#list elections>
            <#items as election>
                <h1>${election.title}</h1>
                <#list election.races>
                    <#items as race>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">${race.title} -- ${race.id}</h3>
                        </div>
                        <div class="panel-body">
                            <#list race.games>
                                <#items as game>
                                    <div class="well col-md-1 col-md-offset-1 text-center gameCard">
                                        <div class="row">${game.title}</div>
                                        <div class="row">Votes: ${game.numVotes}</div>
                                        <div class="row"><button type="button" class="btn btn-primary" ng-click="vote(${race.id}, ${game.id})">Vote</button></div>
                                    </div>
                                </#items>
                            </#list>
                        </div>
                    </div>
                    </#items>
                </#list>
            </#items>
        </#list>
</section>
</@index.page>