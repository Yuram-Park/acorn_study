let tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
// <script src = "https://www.youtube.com/iframe_api"></script>
let firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.
let player;
function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        // <div id="player"></div>
        videoId: 'An6LvWQuj_8',
        // https://developers.google.com/youtube/player_parameters.html?playerVersion=HTML5&hl=ko#Parameters
        playerVars:{
            autoplay: true,
            loop: true,
            playlist: 'An6LvWQuj_8'
        },
        events: {
            'onReady': function(ev){
                ev.target.mute()
            }
            
        }
    });
}

