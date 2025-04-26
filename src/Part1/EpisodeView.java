package Part1;

/**
 EpisodeView represents an episode with an ability to start playing from a specific second.
 It holds the episode and the start time (in seconds) where the playback will start.
 */

public class EpisodeView {
    private Episode episode;
    private int startAtSec;


    public EpisodeView(Episode episode, int startAtSec) {
        this.episode = episode;
        this.startAtSec = startAtSec;
    }


    public void play() {
        System.out.println("Playing \"" + episode.getTitle() + "\" from " + startAtSec + " seconds.");
    }


    public Episode getEpisode() {
        return episode;
    }


    public int getStartAtSec() {
        return startAtSec;
    }
}
