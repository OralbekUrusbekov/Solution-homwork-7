package Part1;

import java.util.Iterator;
import java.util.List;

/**
 * BingeIterator allows seamless iteration over all episodes
 * in all seasons of a Series — like Netflix "Play Next".
 */
public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    /**
     * Constructs a BingeIterator from a Series.
     * Automatically starts from Season 0 if available.
     */
    public BingeIterator(Series series) {
        this.seasons = series.getSeasons();
        if (!seasons.isEmpty()) {
            currentIterator = new SeasonIterator(seasons.get(0));
        }
    }

    /**
     * Checks if there is a next episode across all seasons.
     * Automatically switches to the next season if the current one is exhausted.
     */
    @Override
    public boolean hasNext() {
        while (currentIterator != null) {
            if (currentIterator.hasNext()) {
                return true;
            } else {
                seasonIndex++;
                if (seasonIndex < seasons.size()) {
                    currentIterator = new SeasonIterator(seasons.get(seasonIndex));
                } else {
                    currentIterator = null;
                }
            }
        }
        return false;
    }

    /**
     * Returns the next episode in binge mode.
     */
    @Override
    public Episode next() {
        return currentIterator.next();
    }
}
