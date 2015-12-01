/**
 * Created by ldowell on 11/25/15.
 */
$(document).ready(function() {
    console.log("jquery can suck it");

    $(".vote-btn").on('click', function() {
        vote($(this));
    });

    $("#submitGameBtn").on('click', function() {
        submitGame($(this));
    });

});

function submitGame($el) {
    var gameTitle = $("#game").val();

    $.ajax("/api/v1/game/" + gameTitle, {
        type: "POST",

        success: function(response) {
            console.log(response);
            switch(response.status) {
                case 1:
                    insertNewGame(response.result);
                    break;

                case 0:
                    break;
            }
        }
    })
}

function insertNewGame(game) {
    var $gameContainer = $("#gameContainer");

    var $gameCard = $("<div/>", {class: "well gameCard"});
    var $rowOne = $("<div/>", {class: "row"});
    var $rowTwo = $rowOne.copy();

    //$rowOne.text("Title: ")
    $gameCard.append($rowOne);
    $gameCard.append($rowTwo);
}

/**
 * Attempts to vote on a specific entry
 * @param $el
 */
function vote($el) {
    var entryId = $el.data('entryid');
    var voteSpan = $el.parent().prev().children().last(); //Mmmm good 'ol jquery

    $.ajax("/api/v1/vote/" + entryId, {
        type: "POST",

        success: function(response) {
            if(response.status === 1) {

                console.log("Yay",  response);
                var votes = parseInt(voteSpan.text()) + 1;
                voteSpan.text(votes);

            } else if (response.status === 0) {
                console.log("Oh no" , response);
            }
        }
    })
}