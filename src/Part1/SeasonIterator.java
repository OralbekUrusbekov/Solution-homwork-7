package Part1;

public class SeasonIterator implements EpisodeIterator, Iterator<Episode> {
    private List<Episode> episodes;
    private int currentIndex = 0;

    public SeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex++);
    }
}

