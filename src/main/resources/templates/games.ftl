<#import "util/index.ftl" as index>

<@index.page>
    <!-- VIEW AND ADD NEW GAMES -->
    <section class="container" ng-controller="GamesController">
        <h1 class="text-center"> GAMES VIEW </h1>

        <div class="panel panel-danger">
            <div class="panel-heading">
                <h2 class="panel-title">Add a Game</h2>
            </div>
            <div class="panel-body text-center">
                <form>
                    <div class="form-group">
                        <label for="game">Game Title:</label>
                        <input type="text" id="game" name="game" class="form-control" ng-model="gameTitle">
                    </div>
                    <button class="btn btn-primary" type="button" ng-click="submitGame(gameTitle)">Submit!</button>
                </form>
            </div>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <h2 class="panel-title">Current game library: </h2>
            </div>
            <div class="panel-body container-fluid">
                <#list gameList>
                    <#items as game>
                        <div class="well gameCard">
                            <div class="row"><p>Title: ${game.title}</p></div>
                            <div class="row"><p>ID: ${game.id}</p></div>
                        </div>
                    </#items>
                </#list>
            </div>
        </div>
    </section>
</@index.page>