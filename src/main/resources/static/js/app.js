/**
 * Created by ldowell on 11/25/15.
 */
$(document).ready(function() {
    console.log("jquery can suck it");

    $(".vote-btn").on('click', function() {
        vote($(this));
    });
});


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