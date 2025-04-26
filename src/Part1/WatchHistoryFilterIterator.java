package Part1;

import java.util.Set;

/**
  WatchHistoryFilterIterator filters out episodes that have already been watched
  and only yields unwatched episodes from the base iterator.
 */

public class WatchHistoryFilterIterator implements EpisodeIterator {
    private EpisodeIterator baseIterator;
    private Set<String> watchedTitles;
    private Episode nextUnwatched;


    public WatchHistoryFilterIterator(EpisodeIterator baseIterator, Set<String> watchedTitles) {
        this.baseIterator = baseIterator;
        this.watchedTitles = watchedTitles;
        advance();
    }


    private void advance() {
        nextUnwatched = null;
        while (baseIterator.hasNext()) {
            Episode e = baseIterator.next();
            if (!watchedTitles.contains(e.getTitle())) {
                nextUnwatched = e;
                break;
            }
        }
    }


    @Override
    public boolean hasNext() {
        return nextUnwatched != null;
    }


    @Override
    public Episode next() {
        Episode result = nextUnwatched;
        advance();
        return result;
    }
}
