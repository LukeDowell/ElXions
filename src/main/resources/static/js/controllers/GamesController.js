/**
 * Created by ldowell on 11/24/15.
 */
app.controller("GamesController", function($scope, $http) {
    console.log("Games controller hit");

    $scope.submitGame = function(title) {
        $http({
            method: "POST",
            url: "/api/v1/game/" + title
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