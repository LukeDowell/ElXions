/**
 * Created by ldowell on 11/24/15.
 */
app.controller("AdminController", function($scope, $http) {
    console.log("Admin controller hit");

    $scope.addElection = function(title) {
        $http({
            method: "POST",
            url: "/api/v1/election/" + title
        }).then(
            function(response) {
                console.log(response);
            },
            function(response) {
                console.log(response);
            }
        )
    };

    $scope.addRace = function(raceTitle, electionId) {

    }

    $scope.electionSelected = function(electionId) {
        console.log(electionId);
    }
});