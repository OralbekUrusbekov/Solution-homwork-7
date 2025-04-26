package Part1;

import java.util.*;

/**
  The Season class holds a collection of episodes.
  It allows adding episodes and iterating through them using a default iterator (SeasonIterator).
 */
public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();


    public void addEpisode(Episode e) {
        episodes.add(e);
    }


    public List<Episode> getEpisodes() {
        return episodes;
    }


    @Override
    public Iterator<Episode> iterator() {
        return new SeasonIterator(this);
    }
}
