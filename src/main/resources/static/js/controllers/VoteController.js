/**
 * Created by ldowell on 11/24/15.
 */
app.controller("VoteController", function($scope, $http) {
    console.log("Vote Controller hit");

    $scope.vote = function(raceId, gameId) {
        $http({
            method: "POST",
            url: "/api/v1/vote/" + raceId + "/" + gameId
        }).then(
            function(response) {
                console.log(response);
            },
            function(response) {
                console.log(response);
            }
        )
    }

});