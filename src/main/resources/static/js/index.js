$(document).ready(function () {
    $('#goToShareVideoBtn').click(function (event) {
        event.preventDefault();
        goToPage('/share-video');
    });

    $('#shareVideoBtn').click(function (event) {
        event.preventDefault();
        const youtubeUrl = $('#youtubeUrl').val();
        const params = new URLSearchParams(youtubeUrl.split('?')[1]);
        let videoId = params.get('v');

        shareVideo('/videos', videoId)
    })
});

function goToPage(url) {
    window.location.href = url;
}

function shareVideo(url, id) {
    $.ajax({
        type: "POST",
        url: url + '/' + id,
        success: function (response) {
            goToPage('/');
        },
        error: function (xhr, status, error) {
            $('#shareErrorMsg').removeClass('invisible');
            // Handle any errors that occurred during the request
        }
    });
}
