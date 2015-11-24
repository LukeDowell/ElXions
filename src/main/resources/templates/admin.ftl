<#import "util/index.ftl" as index>

<@index.page>
    <!-- ADD AN ELECTION, ADD RACES, ADD GAMES TO RACES -->
    <section class="container" ng-controller="AdminController">

        <!-- ELECTIONS CONTENT -->
        <div class="row text-center">
            <h2>Elections</h2>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Create an election</h2>
                    </div>
                    <div class="panel-body">
                        <form>
                            <div class="form-group">
                                <label for="electionTitle">Election Title:</label>
                                <input type="text" id="electionTitle" class="form-control" ng-model="electionTitle"/>
                            </div>
                            <button type="button" class="btn btn-primary" ng-click="addElection(electionTitle)">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Running elections</h2>
                    </div>
                    <div class="panel-body">
                        <#list currentElections>
                            <#items as election>
                                <div class="well col-md-1 col-md-offset-1 gameCard">
                                    ${election.title}
                                </div>
                            </#items>
                        </#list>
                    </div>
                </div>
            </div>
        </div>

        <!-- RACES CONTENT -->
        <div class="row text-center">
            <h2>Races</h2>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Create a race</h2>
                    </div>
                    <div class="panel-body">
                        <form ng-model="race">
                            <div class="form-group">
                                <label for="raceTitle">Race Title:</label>
                                <input class="form-control" type="text" id="raceTitle" ng-model="race.title"/>
                            </div>
                            <div class="form-group">
                                <label>Parent Election:</label>
                                <div class="btn-group" uib-dropdown>
                                    <button type="button" class="btn btn-primary form-control" uib-dropdown-toggle>
                                        Choose Election
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <#list currentElections>
                                            <#items as election>
                                                <li role="menuitem"><a href="#" ng-click="electionSelected(${election.electionId})">${election.title}</a></li>
                                            </#items>
                                        </#list>
                                    </ul>
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary" ng-click="addRace(race)">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">Current races:</h2>
                    </div>
                    <div class="panel-body">
                        <#list currentRaces>
                            <#items as race>
                                <div class="well col-md-1 col-md-offset-1 gameCard">
                                    ${race.title}
                                </div>
                            </#items>
                        </#list>
                    </div>
                </div>
            </div>
        </div>

    </section>
</@index.page>