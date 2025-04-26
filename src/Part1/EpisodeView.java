package Part1;

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
