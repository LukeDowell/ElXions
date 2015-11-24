/**
 * Created by ldowell on 11/24/15.
 */

var app = angular.module('app', []);

app.controller('HomeController', function($scope, $http) {

});

app.controller('VoteController', function($scope, $http) {

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