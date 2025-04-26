package Part1;


/**
  Interface for iterating over episodes.
  Defines methods for checking if there is a next episode (hasNext)
  and for retrieving the next episode (next).
 */
public interface EpisodeIterator {
    boolean hasNext();  // Checks if there is another episode
    Episode next();     // Returns the next episode
}
